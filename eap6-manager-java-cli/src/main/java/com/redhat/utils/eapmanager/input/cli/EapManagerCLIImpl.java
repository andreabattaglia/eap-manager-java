/*
 *
 */
package com.redhat.utils.eapmanager.input.cli;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.actions.ActionManager;
import com.redhat.utils.eapmanager.configuration.EnvironmentConfigurationManager;
import com.redhat.utils.eapmanager.constants.MessageConstants;
import com.redhat.utils.eapmanager.exceptions.EAPManException;
import com.redhat.utils.eapmanager.input.EapManagerCLI;
import com.redhat.utils.eapmanager.systemc.ApplicationScopedClass;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
@ApplicationScoped
public class EapManagerCLIImpl 
        implements EapManagerCLI {
    @Inject
    private Logger LOG;

    @Inject
    private EnvironmentConfigurationManager environmentConfigurationManager;
    @Inject
    private ActionManager actionsManagerImpl;

    private String environmentsMenu;
    private String actionsMenu;

    private String header;

    private String footer;

    private List<String> environmentNames;
    private List<String> actionNames;

    public EapManagerCLIImpl() {
        buildHeader();
        buildFooter();
    }

    private void buildHeader() {
        header = MessageConstants.APPLICATION_NAME.getValue() + "\n\n";
    }

    private void buildFooter() {
        footer = " 0 - Back\n\nYour choice: ";
    }

    /**
     * @see com.redhat.utils.eapmanager.systemc.ApplicationScopedClass#init()
     */
    @PostConstruct
    protected void init() {
        environmentNames = new LinkedList<>(
                environmentConfigurationManager.getEnvironmentNames());
        environmentsMenu = buildMenu(
                MessageConstants.CONFIGURED_ENVIRONMENTS.getValue(),
                environmentNames);
        actionNames = new LinkedList<>(actionsManagerImpl.getActionNames());
        environmentsMenu = buildMenu(
                MessageConstants.AVAILABLE_EAPMAN_ACTIONS.getValue(),
                actionNames);
    }

    private String buildMenu(String initialMessage, List<String> names) {
        short i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(header)//
                .append(initialMessage)//
                .append('\n')//
                .append('\n');
        for (String env : names) {
            sb.append(String.format("% 2d", ++i))//
                    .append(" - ")//
                    .append(env)//
                    .append('\n');
        }
        sb.append(footer);
        return sb.toString();
    }

    /**
     * @see com.redhat.utils.eapmanager.input.cli.EapManagerCLI#start()
     */
    @Override
    public void start() {
        if (System.console() != null) {
            useConsole();
        } else {
            useReader();
        }
    }

    /**
     *
     */
    private void useConsole() {
        Console cons = System.console();
        while (true) {
            String value = cons.readLine(environmentsMenu);
            manageRequest(value);
        }

    }

    /**
     *
     */
    private void useReader() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            System.out.println(environmentsMenu);
            String value = null;
            try {
                value = reader.readLine();
                manageRequest(value);
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage());
            }
        }
    }

    /**
     * @param value
     */
    private void manageRequest(String value) {
        try {
            short id = Short.parseShort(value);
            if (id == 0) {
                System.out.println("Goodbye\n");
                System.exit(0);
            }
            try {
                environmentConfigurationManager
                        .selectEnvironment(environmentNames.get(id - 1));
            } catch (EAPManException e) {
                LOG.error("",e);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("NAN");
        }
    }
}
