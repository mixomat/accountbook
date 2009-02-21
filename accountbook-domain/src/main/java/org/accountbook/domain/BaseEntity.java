package org.accountbook.domain;

/**
 * Base bean for all domain model classes.
 * 
 * Implements {@link equals(Object other)} {@link hashCode()}, which is required for ORM entity comparison.
 * 
 *  
 * @author marc
 * @param <T>
 *
 */
public abstract class BaseEntity<T> implements Entity<T> {

	public abstract Long getId();
	
	public abstract void setId(Long id);
	
	
	/**
	 * @see org.accountbook.domain.Entity#sameIdentityAs(java.lang.Object)
	 */
	public boolean sameIdentityAs(T other) {
		return equals(other);
	}
	
	/**
	 * The following methods are taken from
	 * http://forum.hibernate.org/viewtopic.php?p=2191778
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(this.getClass().isInstance(other)))
			return false;
		BaseEntity<T> castOther = (BaseEntity<T>) other;
		if (this.getId() == null)
			return false;
		if (castOther.getId() == null)
			return false;
		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId()
				.equals(castOther.getId())));
	}

	@Override
	public int hashCode() {
		Object o = getEqualityObject();
		if (o == this) {
			return super.hashCode();
		} else {
			return o.hashCode();
		}
	}

	private Object equalityObject;

	private Object getEqualityObject() {
		if (equalityObject == null)
			equalityObject = (getId() == null) ? this : getId();
		return equalityObject;
	}

}
