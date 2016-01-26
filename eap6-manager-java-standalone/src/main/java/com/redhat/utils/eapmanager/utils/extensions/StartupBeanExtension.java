/*
 *
 */
package com.redhat.utils.eapmanager.utils.extensions;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;

import com.redhat.utils.eapmanager.utils.annotations.Startup;

/**
 * The Class StartupBeanExtension.
 *
 * @author Andrea Battaglia (Red Hat)
 */
public class StartupBeanExtension implements Extension {

    /** The startup beans. */
    private final Set<Bean<?>> startupBeans = new LinkedHashSet<Bean<?>>();

    /**
     * Process bean.
     *
     * @param <X> the generic type
     * @param event the event
     */
    <X> void processBean(@Observes ProcessBean<X> event) {
        if (event.getAnnotated().isAnnotationPresent(Startup.class) && event
                .getAnnotated().isAnnotationPresent(ApplicationScoped.class)) {
            startupBeans.add(event.getBean());
        }
    }

    /**
     * After deployment validation.
     *
     * @param event the event
     * @param manager the manager
     */
    void afterDeploymentValidation(@Observes AfterDeploymentValidation event,
            BeanManager manager) {
        for (Bean<?> bean : startupBeans) {
            // the call to toString() is a cheat to force the bean to be
            // initialized
            manager.getReference(bean, bean.getBeanClass(),
                    manager.createCreationalContext(bean)).toString();
        }
    }
}