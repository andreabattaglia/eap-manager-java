/**
 *
 */
package com.redhat.utils.eapmanager.application;

import java.lang.reflect.Type;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public abstract class StandaloneApplication implements Runnable {
    /**
     * Logger for this class
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(StandaloneApplication.class);

    private Weld weld = null;
    private ShutdownHook shutdownHook;
    private WeldContainer container = null;

    public final void startup() {
        LOG.info("Initialization started...");
        weld = new Weld();
        // cdiNettyJaxrsServer = new CdiNettyJaxrsServer();
        shutdownHook = new ShutdownHook(weld
        // , cdiNettyJaxrsServer
        );
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        LOG.info("Starting CDI container...");
        container = weld.initialize();
        LOG.info("CDI container started...");

        LOG.info("Initialization completed...");
    }

    /**
     * Shut down Weld immediately. Removes shutdown hook. Blocks until Weld is
     * completely shut down.
     */
    public void shutdownNow() {
        Runtime.getRuntime().removeShutdownHook(shutdownHook);
        shutdownHook.run();
    }

    static class ShutdownHook extends Thread {
        private static final Logger LOG = LoggerFactory
                .getLogger(ShutdownHook.class);

        private final Weld weld;
        // private CdiNettyJaxrsServer cdiNettyJaxrsServer;

        ShutdownHook(Weld weld
        // , CdiNettyJaxrsServer cdiNettyJaxrsServer
        ) {
            this.weld = weld;
            // this.cdiNettyJaxrsServer = cdiNettyJaxrsServer;
        }

        @Override
        public void run() {
            LOG.info("Shutdown started...");

            // LOG.info("Stopping REST server...");
            // cdiNettyJaxrsServer.stop();
            // LOG.info("REST server stopped...");

            LOG.info("Stopping CDI container...");
            weld.shutdown();
            LOG.info("CDI container stopped...");

            LOG.info("Shutdown completed...");
        }
    }
}
