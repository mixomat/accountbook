/**
 * 
 */
package org.accountbook.repository.hibernate.internal;

import java.util.List;

import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;
import org.accountbook.repository.hibernate.ExpenseRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * Hibernate repository implementation for expense persistence.
 * 
 * @author marc
 * @since 1.0.0
 */
public class HibernateExpenseRepository extends HibernateRepository<Expense>
		implements ExpenseRepository {

	/**
	 * @see org.accountbook.repository.hibernate.ExpenseRepository#findByUser(org.accountbook.domain.model.User)
	 */
	@SuppressWarnings("unchecked")
	public List<Expense> findByUser(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Expense.class).add(Restrictions.eq("user", user));
		return hibernateTemplate.findByCriteria(criteria);
	}

}
