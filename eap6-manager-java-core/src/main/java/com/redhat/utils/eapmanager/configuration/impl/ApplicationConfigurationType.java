/**
 *
 */
package com.redhat.utils.eapmanager.configuration.impl;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public enum ApplicationConfigurationType {
    ENV_CONFIG_FOLDER("cfg.env.folder"),
    //
    ;

    /** The value. */
    private final String value;

    /**
     * Instantiates a new constants.
     *
     * @param value
     *            the value
     */
    private ApplicationConfigurationType(String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
