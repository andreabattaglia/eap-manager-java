/*
 *
 */
package com.redhat.utils.eapmanager.configuration;

import java.util.Set;

import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentConfigurationType;
import com.redhat.utils.eapmanager.exceptions.EAPManException;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public interface EnvironmentConfigurationManager {
    /**
     * @return
     */
    String getCurrentEnvironmentName();

    Set<String> getEnvironmentNames();

    /**
     * @param configurationType
     * @return
     */
    String getConfiguration(EnvironmentConfigurationType configurationType);

    /**
     * @param environmentName
     * @return
     * @throws EAPManException
     */
    void selectEnvironment(String environmentName) throws EAPManException;

    /**
     * @param environmentName
     * @param key
     * @return
     */
    String getConfiguration(String environmentName,
            EnvironmentConfigurationType configurationType);

    /**
     * @param environmentName
     * @param host
     * @param port
     * @param username
     * @param password
     */
    void addEnvironment(String environmentName, String host, int port,
            String realm, String username, String password);

    /**
     * @param environmentName
     * @param host
     * @param port
     * @param realm
     * @param username
     * @param password
     */
    void updateEnvironment(String environmentName, String host, int port,
            String realm, String username, String password);

}
