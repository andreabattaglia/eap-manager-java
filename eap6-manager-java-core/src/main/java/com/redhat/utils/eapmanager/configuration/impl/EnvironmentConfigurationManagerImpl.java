/**
 *
 */
package com.redhat.utils.eapmanager.configuration.impl;

import static com.redhat.utils.eapmanager.constants.ObjectMapperType.DEFAULT_MAPPER;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentConfigurationType;
import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentDTO;
import com.redhat.utils.eapmanager.configuration.ConfigurationManager;
import com.redhat.utils.eapmanager.connectionmanager.DMRConnectionManager;
import com.redhat.utils.eapmanager.connectionmanager.impl.NotInDomainModeException;
import com.redhat.utils.eapmanager.events.EnvironmentSelectedEvent;
import com.redhat.utils.eapmanager.exceptions.EAPManException;
import com.redhat.utils.eapmanager.utils.annotations.Startup;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
@ApplicationScoped
@Startup
public class EnvironmentConfigurationManagerImpl
        extends AbstractEnvironmentConfigurationManager {

    private static final ConfigurationFileFilter CONFIGURATION_FILE_FILTER = new ConfigurationFileFilter();

    // @Inject
    // private PropertiesEnvironmentAdapter adapter;
    @Inject
    private ConfigurationManager configurationManager;

    @Inject
    private DMRConnectionManager dmrConnectionManager;

    @Inject
    private Event<EnvironmentSelectedEvent> environmentSelectedEvent;

    @Inject
    private Logger LOG;

    private Path envConfigPath;

    private String currentEnvironmentName;
    private EnvironmentDTO currentEnvironment;
    private final Map<String, EnvironmentDTO> environments;

    /**
     *
     */
    public EnvironmentConfigurationManagerImpl() {
        environments = new TreeMap<>();
    }

    @PostConstruct
    private void init() {
        envConfigPath = Paths.get(configurationManager.getConfiguration(
                ApplicationConfigurationType.ENV_CONFIG_FOLDER));
        loadConfigurations();
    }

    private void loadConfigurations() {
        EnvironmentDTO environment = null;
        Set<Path> environmentConfigurationFiles = searchForEnvironmentConfigurations();
        for (Path ecf : environmentConfigurationFiles) {
            try {
                environment = loadEnvironment(ecf);
            } catch (Exception e) {
                LOG.warn(
                        "Can't load environment from disc {} because of \"{}\".",
                        ecf, e.getMessage());
            }
            environments.put(environment.getId(), environment);
        }
    }

    private Set<Path> searchForEnvironmentConfigurations() {
        Set<Path> environmentFiles = new LinkedHashSet<>();
        try (DirectoryStream<Path> directoryStream = Files
                .newDirectoryStream(envConfigPath, CONFIGURATION_FILE_FILTER)) {
            for (Path configFilePath : directoryStream) {
                environmentFiles.add(configFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Error loading environments.", e);
        }
        return environmentFiles;
    }

    private EnvironmentDTO loadEnvironment(Path configFilePath)
            throws Exception {
        EnvironmentDTO environment = DEFAULT_MAPPER.getObjectMapper()
                .readValue(configFilePath.toFile(), EnvironmentDTO.class);
        String fileName = configFilePath.getFileName().toString();
        environment.setId(fileName.substring(0, fileName.lastIndexOf('.')));
        // environmentAddedEvent.fire(new StartCollectorEvent(environment));
        return environment;
    }

    @Override
    public String getCurrentEnvironmentName() {
        return currentEnvironmentName;
    }

    @Override
    public Set<String> getEnvironmentNames() {
        return Collections.unmodifiableSet(environments.keySet());
    }

    @Override
    public synchronized void selectEnvironment(String environmentName)
            throws EAPManException {
        if (environments.containsKey(environmentName)) {
            currentEnvironmentName = environmentName;
            // EnvironmentSelectedEvent ese = new EnvironmentSelectedEvent();
            // ese.setEnvironmentName(environmentName);
            // environmentSelectedEvent.fire(ese);
            dmrConnectionManager.connect(environments.get(environmentName));
        } else {
            throw new IllegalArgumentException(
                    "No environment \"" + environmentName + "\" loaded.");
        }
    }

    @Override
    public String getConfiguration(
            EnvironmentConfigurationType configurationType) {
        return getConfiguration(currentEnvironment, configurationType);
    }

    @Override
    public String getConfiguration(String environmentName,
            EnvironmentConfigurationType configurationType) {
        return getConfiguration(environments.get(environmentName),
                configurationType);
    }

    private String getConfiguration(EnvironmentDTO environment,
            EnvironmentConfigurationType configurationType) {
        switch (configurationType) {
        case hostname:
            return environment.getHostname();
        case port:
            return environment.getPort();
        case realm:
            return environment.getRealm();
        case username:
            return environment.getUsername();
        case password:
            return environment.getPassword();
        }
        throw new IllegalArgumentException(
                "Invalid Configuration Type: " + configurationType);
    }

    @Override
    public void addEnvironment(String environmentName, String host, int port,
            String realm, String username, String password) {
        if (environments.containsKey(environmentName)) {
            throw new IllegalArgumentException(
                    "Environment \"" + environmentName + "\" already exists");
        }
        Path environmentFileName = createEnvironmentFile();
        importEnvironmentConfiguration(environmentFileName);
    }

    @Override
    public void updateEnvironment(String environmentName, String host, int port,
            String realm, String username, String password) {
        if (!environments.containsKey(environmentName)) {
            throw new IllegalArgumentException(
                    "Environment \"" + environmentName + "\" does not exist");
        }
        Path environmentFileName = createEnvironmentFile();
        importEnvironmentConfiguration(environmentFileName);
    }

    private Path createEnvironmentFile() {
        // TODO Auto-generated method stub
        return null;
    }

    private void importEnvironmentConfiguration(Path environmentFile) {
        // TODO Auto-generated method stub

    }
}
