/**
 *
 */
package com.redhat.utils.eapmanager.actions.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.actions.Action;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
@Dependent
public abstract class AbstractAction implements Action {
    @Inject
    protected Logger LOG;

}
