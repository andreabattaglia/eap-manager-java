/**
 *
 */
package com.redhat.utils.eapmanager.actions.impl;

import com.redhat.utils.eapmanager.actions.Action;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
public class SayHelloAction implements Action {

    @Override
    public String getActionName() {
        return "Say something";
    }

    /**
     * @see com.redhat.utils.eapmanager.actions.Action#doSomething(java.lang.String)
     */
    @Override
    public String doSomething(String input) {
        return input;
    }

}
