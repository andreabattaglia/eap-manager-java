/**
 *
 */
package com.redhat.utils.eapmanager.configuration.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.constants.ApplicationConstants;
import com.redhat.utils.eapmanager.constants.FolderConstants;
import com.redhat.utils.eapmanager.utils.annotations.Startup;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
@ApplicationScoped
@Startup
public class ConfigurationManagerImpl extends AbstractConfigurationManager {
    @Inject
    private Logger LOG;

    private final Properties appConfiguration;

    private Path cfgFile;

    /**
     *
     */
    public ConfigurationManagerImpl() {
        appConfiguration = new Properties();
        // environments = new PRB\();
    }

    @PostConstruct
    private void init() {
        /*
         * this snippet is to be moved in some other bootstrap class
         */
        try {
            Path configFolder = Paths
                    .get(FolderConstants.CONFIG_FOLDER.getValue());
            Path envFolder = Paths
                    .get(FolderConstants.ENVIRONMENT_FOLDER.getValue());
            Path logFolder = Paths.get(FolderConstants.LOG_FOLDER.getValue());
            Files.createDirectories(configFolder);
            Files.createDirectories(envFolder);
            Files.createDirectories(logFolder);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        /*
         *
         */
        appConfiguration.setProperty(
                ApplicationConfigurationType.ENV_CONFIG_FOLDER.getValue(),
                FolderConstants.ENVIRONMENT_FOLDER.getValue());

        initConfigFile();
        try (InputStream is = Files.newInputStream(cfgFile)) {
            appConfiguration.load(is);
        } catch (IOException e)

        {
            LOG.error("An error occurred initializing properties file.", e);
        }

    }

    private void initConfigFile() {
        cfgFile = Paths.get(FolderConstants.CONFIG_FOLDER.getValue(),
                ApplicationConstants.APP_CONFIG_FILE.getValue());
        try {
            if (Files.notExists(cfgFile)) {
                LOG.debug("Creating brand new configuration "
                        + "file with default options.");
                Files.createFile(cfgFile);
            }
        } catch (IOException e) {
        }
    }

    @Override
    public String getConfiguration(ApplicationConfigurationType key) {
        return appConfiguration.getProperty(key.getValue());
    }
}
