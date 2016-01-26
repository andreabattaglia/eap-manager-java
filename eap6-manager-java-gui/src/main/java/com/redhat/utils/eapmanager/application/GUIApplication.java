/**
 *
 */
package com.redhat.utils.eapmanager.application;

import javax.enterprise.inject.spi.CDI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.utils.eapmanager.input.EapManagerGUI;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public class GUIApplication extends StandaloneApplication {
    /**
     * Logger for this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(GUIApplication.class);

    public static void main(String[] args) {
        new Thread(new GUIApplication()).start();
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        super.startup();
        EapManagerGUI cli = CDI.current().select(EapManagerGUI.class).get();
        cli.start();
    }
}
