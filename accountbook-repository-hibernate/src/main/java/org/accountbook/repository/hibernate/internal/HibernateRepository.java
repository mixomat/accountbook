package org.accountbook.repository.hibernate.internal;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.accountbook.domain.Entity;
import org.accountbook.repository.hibernate.Repository;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Abstract {@link Repository} implementation, acting as base for all hibernate
 * based repository access.
 * 
 * @author marc
 */
public abstract class HibernateRepository<T extends Entity<T>> implements
		Repository<T> {

	public HibernateTemplate hibernateTemplate;

	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public HibernateRepository() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T find(Long id) {
		return (T) hibernateTemplate.get(persistentClass, id);
	}

	public List<T> findAll() {
		return hibernateTemplate.loadAll(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T entity) {
		return hibernateTemplate.findByExample(entity);
	}

	public void save(T entity) {
		assert (entity != null);
		hibernateTemplate.save(entity);
	}

	public void saveAll(List<T> entities) {
		hibernateTemplate.saveOrUpdateAll(entities);
	}

	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}
	
	public void flush() {
		hibernateTemplate.flush();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

}
