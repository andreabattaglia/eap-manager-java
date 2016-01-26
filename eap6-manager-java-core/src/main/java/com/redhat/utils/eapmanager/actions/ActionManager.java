/*
 * 
 */
package com.redhat.utils.eapmanager.actions;

import java.util.Map;
import java.util.Set;

public interface ActionManager {

    Set<String> getActionNames();

//    Map<Short, String> getActionsMap();

    String executeAction(short actionId, String args);

}