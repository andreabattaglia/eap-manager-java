/**
 *
 */
package com.redhat.utils.eapmanager.utils.adapters.impl;

import com.redhat.utils.eapmanager.utils.adapters.Adapter;

// TODO: Auto-generated Javadoc
/**
 * The Class NullSafeAdapter.
 *
 * @author Ing. Andrea Battaglia
 * @param <A>
 *            the generic type
 * @param <X>
 *            the generic type
 */
public abstract class NullSafeAdapter<A, X> implements Adapter<A, X> {

    /**
     * @see com.redhat.utils.eapmanager.utils.adapters.Adapter#from(java.lang.Object)
     */
    @Override
    public A from(X source) {
        if (source == null) {
            return null;
        } else {
            return nullSafeFrom(source);
        }
    }

    /**
     * Null safe from.
     *
     * @param source
     *            the source
     * @return the a
     */
    protected abstract A nullSafeFrom(X source);

    /**
     * @see com.redhat.utils.eapmanager.utils.adapters.Adapter#to(java.lang.Object)
     */
    @Override
    public X to(A source) {
        if (source == null) {
            return null;
        } else {
            return nullSafeTo(source);
        }
    }

    /**
     * Null safe to.
     *
     * @param source
     *            the source
     * @return the x
     */
    protected abstract X nullSafeTo(A source);

}
