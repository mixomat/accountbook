/**
 * 
 */
package org.accountbook.repository.hibernate.impl;

import static org.junit.Assert.*;

import org.accountbook.domain.model.Expense;
import org.accountbook.repository.hibernate.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Tests wiring and access to expense hibernate repository.
 * @author marc
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bundle-context-test.xml"})
public class HibernateExpenseRepositoryTest {

	@Autowired
	Repository<Expense> expenseRepository;
	
	@Test
	public void testLoadById() throws Exception {
		Expense expense = new Expense();
		expense.setAmount(20.0);
		
		// persist expense first
		expenseRepository.save(expense);
		
		assertNotNull(expenseRepository.findById(1l));
		assertEquals(new Long(1l), expenseRepository.findById(1l).getId());
	}
}
