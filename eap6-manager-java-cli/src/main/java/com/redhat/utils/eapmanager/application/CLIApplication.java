/**
 *
 */
package com.redhat.utils.eapmanager.application;

import javax.enterprise.inject.spi.CDI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.utils.eapmanager.input.EapManagerCLI;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public class CLIApplication extends StandaloneApplication {
    /**
     * Logger for this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(CLIApplication.class);

    public static void main(String[] args) {
        new Thread(new CLIApplication()).start();
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        super.startup();
        EapManagerCLI cli = CDI.current().select(EapManagerCLI.class).get();
        cli.start();
    }
}
