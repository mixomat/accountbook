/**
 * 
 */
package org.accountbook.repository.hibernate.internal;

import org.accountbook.domain.model.Expense;
import org.accountbook.repository.hibernate.ExpenseRepository;

/**
 * Hibernate repository implementation for expense persistence.
 * 
 * @author marc
 * @since 1.0.0
 */
public class HibernateExpenseRepository extends HibernateRepository<Expense>
		implements ExpenseRepository {

}
