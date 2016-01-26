/**
 *
 */
package com.redhat.utils.eapmanager.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class EAPManException.
 *
 * @author Andrea Battaglia (Red Hat)
 */
public abstract class EAPManException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 976609505788227100L;

    /**
     * Instantiates a new EAP man exception.
     */
    public EAPManException() {
    }

    /**
     * Instantiates a new EAP man exception.
     *
     * @param message
     *            the message
     */
    public EAPManException(String message) {
        super(message);
    }

    /**
     * Instantiates a new EAP man exception.
     *
     * @param cause
     *            the cause
     */
    public EAPManException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new EAP man exception.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public EAPManException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new EAP man exception.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     * @param enableSuppression
     *            the enable suppression
     * @param writableStackTrace
     *            the writable stack trace
     */
    public EAPManException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
