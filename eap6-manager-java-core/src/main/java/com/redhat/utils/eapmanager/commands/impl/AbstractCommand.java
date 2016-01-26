/**
 *
 */
package com.redhat.utils.eapmanager.commands.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.redhat.utils.eapmanager.commands.Command;

/**
 * @author Andrea Battaglia (Red Hat)
 *
 */
@Dependent
public abstract class AbstractCommand<R> implements Command<R> {
    @Inject
    protected Logger LOG;

}
