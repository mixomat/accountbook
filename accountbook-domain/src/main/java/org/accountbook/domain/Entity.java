package org.accountbook.domain;

/**
 * An entity, as explained in the DDD book.
 * 
 * @author marc
 * @since 1.0.0
 */
public interface Entity<T> {

	/**
	 * Entities compare by identity, not by attributes.
	 * 
	 * @param other
	 *            The other entity.
	 * @return true if the identities are the same, regardless of other
	 *         attributes.
	 */
	boolean sameIdentityAs(T other);

}
