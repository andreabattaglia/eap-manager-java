/*
 *
 */
package com.redhat.utils.eapmanager.utils.adapters;

import java.util.List;

/**
 * The Interface Adapter.
 *
 * @param <A>
 *            the generic type
 * @param <X>
 *            the generic type
 */
public interface Adapter<A, X> {

    /**
     * From.
     *
     * @param myBean
     *            the my bean
     * @return the list
     */
    A from(X source);

    /**
     * To.
     *
     * @param raw
     *            the raw
     * @return the b
     */
    X to(A dest);
}
