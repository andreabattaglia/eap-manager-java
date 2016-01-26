/*
 *
 */
package com.redhat.utils.eapmanager.utils.adapters.impl;

import static com.redhat.utils.eapmanager.actions.dto.env.EnvironmentConfigurationType.*;

import java.util.Properties;

import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentDTO;

/**
 * The Class PropertiesEnvironmentAdapter.
 *
 * @author Andrea Battaglia (Red Hat)
 */
// @PropertiesEnvironment
public class PropertiesEnvironmentAdapter
        extends NullSafeAdapter<Properties, EnvironmentDTO> {

    /**
     * @see com.redhat.utils.eapmanager.utils.adapters.impl.NullSafeAdapter#nullSafeTo(java.lang.Object)
     */
    @Override
    protected EnvironmentDTO nullSafeTo(Properties source) {
        EnvironmentDTO environment = new EnvironmentDTO();
        environment.setHostname(source.getProperty(hostname.name()));
        environment.setPort(source.getProperty(port.name()));
        environment.setRealm(source.getProperty(realm.name()));
        environment.setUsername(source.getProperty(username.name()));
        environment.setPassword(source.getProperty(password.name()));
        return environment;
    }

    /**
     * @see com.redhat.utils.eapmanager.utils.adapters.impl.NullSafeAdapter#nullSafeFrom(java.lang.Object)
     */
    @Override
    protected Properties nullSafeFrom(EnvironmentDTO source) {
        Properties properties = new Properties();
        properties.setProperty(hostname.name(), source.getHostname());
        properties.setProperty(port.name(), source.getPort());
        properties.setProperty(realm.name(), source.getRealm());
        properties.setProperty(username.name(), source.getUsername());
        properties.setProperty(password.name(), source.getPassword());
        return properties;
    }

}
