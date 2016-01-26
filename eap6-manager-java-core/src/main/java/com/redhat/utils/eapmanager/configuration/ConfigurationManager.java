/*
 * 
 */
package com.redhat.utils.eapmanager.configuration;

import com.redhat.utils.eapmanager.configuration.impl.ApplicationConfigurationType;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public interface ConfigurationManager {
    /**
     * @param key
     * @return
     */
    String getConfiguration(ApplicationConfigurationType key);
}
