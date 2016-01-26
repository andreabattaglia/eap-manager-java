/*
 * 
 */
package com.redhat.utils.eapmanager.actions.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.actions.Action;
import com.redhat.utils.eapmanager.actions.ActionManager;
import com.redhat.utils.eapmanager.systemc.ApplicationScopedClass;

@ApplicationScoped
public class ActionsManagerImpl 
        implements ActionManager {
    @Inject
    private Logger LOG;

    @Inject
    private Instance<Action> actions;
    private Set<String> actionNames;
    private Map<Short, String> actionsMap;

    @PostConstruct
    protected void init() {
        short i = 0;
        Map<Short, String> m = new TreeMap<>();
        for (Action a : actions) {
            m.put(++i, a.getActionName());
        }
        actionsMap = Collections.unmodifiableMap(m);
        actionNames = Collections
                .unmodifiableSet(new LinkedHashSet<>(m.values()));
    }

    /**
     * @see com.redhat.utils.eapmanager.actions.impl.ActionManager#getActionNames()
     */
    @Override
    public Set<String> getActionNames() {
        return actionNames;
    }

//    /**
//     * @see com.redhat.utils.eapmanager.actions.impl.ActionManager#getActionsMap()
//     */
//    @Override
//    public Map<Short, String> getActionsMap() {
//        return actionsMap;
//    }

    /**
     * @see com.redhat.utils.eapmanager.actions.impl.ActionManager#executeAction(short,
     *      java.lang.String)
     */
    @Override
    public String executeAction(short actionId, String args) {
        return "OK";
    }
}
