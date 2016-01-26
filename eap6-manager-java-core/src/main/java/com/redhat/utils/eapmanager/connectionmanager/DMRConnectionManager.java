/*
 *
 */
package com.redhat.utils.eapmanager.connectionmanager;

import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentDTO;
import com.redhat.utils.eapmanager.connectionmanager.impl.NotInDomainModeException;

/**
 * The Interface DMRConnectionManager.
 *
 * @author Andrea Battaglia (Red Hat)
 */
public interface DMRConnectionManager {

    /**
     * Connect.
     *
     * @param environmentDTO
     *            the environment dto
     * @throws NotInDomainModeException
     */
    void connect(EnvironmentDTO environmentDTO) throws NotInDomainModeException;

}
