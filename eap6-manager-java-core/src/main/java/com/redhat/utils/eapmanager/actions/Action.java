package com.redhat.utils.eapmanager.actions;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public interface Action {
    String getActionName();

    String doSomething(String input);
}
