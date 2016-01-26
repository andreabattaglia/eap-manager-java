/*
 *
 */
package com.redhat.utils.eapmanager.connectionmanager.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.as.cli.scriptsupport.CLI;
import org.jboss.as.controller.client.ModelControllerClient;
import org.slf4j.Logger;

import com.redhat.utils.eapmanager.actions.dto.env.EnvironmentDTO;
import com.redhat.utils.eapmanager.connectionmanager.DMRConnectionManager;
import com.redhat.utils.eapmanager.systemc.ApplicationScopedClass;
import com.redhat.utils.eapmanager.utils.annotations.Startup;

@ApplicationScoped
@Startup
public class DMRConnectionManagerImpl
        implements DMRConnectionManager {
    @Inject
    private Logger LOG;
    // protected ModelControllerClient mcClient;
    private final CLI client;

    public DMRConnectionManagerImpl() {
        client = CLI.newInstance();
    }

    @PostConstruct
    private void init() {
    }

    @PreDestroy
    private void destroy() {
        LOG.debug("Disconnecting from domain controller...");
        if ((client != null) && !client.getCommandContext().isTerminated()) {
            client.disconnect();
        }
    }

    @Override
    public synchronized void connect(EnvironmentDTO environment)
            throws NotInDomainModeException {
        client.connect(environment.getHostname(),
                Integer.parseInt(environment.getPort()),
                environment.getUsername(),
                environment.getPassword().toCharArray());
        if (!client.getCommandContext().isDomainMode()) {
            throw new NotInDomainModeException();
        }
    }
}
