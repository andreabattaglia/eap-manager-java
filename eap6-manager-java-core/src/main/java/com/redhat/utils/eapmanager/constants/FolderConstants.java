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
public enum FolderConstants {

    /** The config folder name. */
    CONFIG_FOLDER_NAME("config"),

    /** The environment folder name. */
    ENVIRONMENT_FOLDER_NAME("environments"),

    /** The log folder name. */
    LOG_FOLDER_NAME("log"),

    /** The config folder. */
    CONFIG_FOLDER("/etc/" + ApplicationConstants.APP_ID.getValue() + "/"
            + CONFIG_FOLDER_NAME.getValue()),

    /** The environment folder. */
    ENVIRONMENT_FOLDER("/etc/" + ApplicationConstants.APP_ID.getValue() + "/"
            + ENVIRONMENT_FOLDER_NAME.getValue()),

    /** The log folder. */
    LOG_FOLDER("/var/log/" + ApplicationConstants.APP_ID.getValue() + "/"
            + LOG_FOLDER_NAME.getValue()),

    /** The lib folder. */
    LIB_FOLDER("/var/lib/" + ApplicationConstants.APP_ID.getValue()),

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
    private FolderConstants(String value) {
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
