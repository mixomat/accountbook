package org.accountbook.repository.hibernate.impl;

import org.accountbook.domain.Entity;
import org.accountbook.repository.hibernate.Repository;

/**
 * Abstract {@link Repository} implementation, acting as base for all hibernate based repository access.
 * @author marc
 *
 */
public abstract class HibernateRepository<T extends Entity<T>> implements Repository<T> {

}
