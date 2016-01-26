/*
 *
 */
package com.redhat.utils.eapmanager.constants;

// TODO: Auto-generated Javadoc
/**
 * The Enum MessageConstants.
 *
 * @author Andrea Battaglia
 */
public enum ApplicationConstants {

    /** The app id. */
    APP_ID("eapman"),

    /** The app name. */
    APP_NAME("JBoss EAP Manager"),

    /** The app version. */
    APP_VERSION("1.0.0.Alpha1"),

    /** The configuration file extension. */
    CONFIGURATION_FILE_EXTENSION(".cfg"),

    /** The app config file. */
    APP_CONFIG_FILE(
            APP_ID.getValue() + CONFIGURATION_FILE_EXTENSION.getValue()),

    /** The value. */
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
    private ApplicationConstants(String value) {
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
