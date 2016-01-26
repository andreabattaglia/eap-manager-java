/*
 *
 */
package com.redhat.utils.eapmanager.input.cli;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.actions.ActionManager;
import com.redhat.utils.eapmanager.constants.MessageConstants;
import com.redhat.utils.eapmanager.input.EapManagerGUI;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
@ApplicationScoped
public class EapManagerGUIImpl implements EapManagerGUI {
    @Inject
    private Logger LOG;

    @Inject
    private ActionManager actionsManagerImpl;

    private String actionsMenu;

    /**
     * @see com.redhat.utils.eapmanager.systemc.ApplicationScopedClass#init()
     */
    @PostConstruct
    protected void init() {
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub

    }

}
