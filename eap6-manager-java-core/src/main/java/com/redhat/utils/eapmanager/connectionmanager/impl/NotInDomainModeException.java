/**
 *
 */
package com.redhat.utils.eapmanager.connectionmanager.impl;

import com.redhat.utils.eapmanager.exceptions.EAPManException;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public final class NotInDomainModeException extends EAPManException {
    /**
     *
     */
    private static final long serialVersionUID = 4962089037516224592L;
    private static final String MESSAGE = "DMR not in Domain Mode!";

    /**
     *
     */
    public NotInDomainModeException() {
        super(MESSAGE);
    }
    //
    // /**
    // * @param message
    // */
    // public NotInDomainModeException(String message) {
    // super(message);
    // }

    /**
     * @param cause
     */
    public NotInDomainModeException(Throwable cause) {
        super(MESSAGE, cause);
    }

    // /**
    // * @param message
    // * @param cause
    // */
    // public NotInDomainModeException(String message, Throwable cause) {
    // super(message, cause);
    // }

    // /**
    // * @param message
    // * @param cause
    // * @param enableSuppression
    // * @param writableStackTrace
    // */
    // public NotInDomainModeException(String message, Throwable cause,
    // boolean enableSuppression, boolean writableStackTrace) {
    // super(message, cause, enableSuppression, writableStackTrace);
    // }

}
