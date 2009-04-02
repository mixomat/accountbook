package org.accountbook.repository.hibernate.internal;

import static org.junit.Assert.*;

import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;
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
	public void testFindWithBasicMappings() throws Exception {
		Expense expense = new Expense();
		expense.setAmount(20.0);
		expense.setCleared(true);
		expense.setUser(new User());
		
		// persist expense first
		expenseRepository.save(expense);
		
		long id = 1l;
		assertNotNull(expenseRepository.find(id));
		assertEquals(new Long(id), expenseRepository.find(id).getId());
		assertEquals("amount should match", new Double(20.0),expenseRepository.find(id).getAmount());
		assertTrue("expense should be cleared", expenseRepository.find(id).isCleared());
	}
	
	@Test
	public void testFindWithAssociationMappings() throws Exception {
		Expense expense = new Expense();
		expense.setAmount(13.45);
		User user = new User("katja");
		expense.setUser(user);
		
		expenseRepository.save(expense);
		Long id = expense.getId();
		assertNotNull(id);
		
		Expense expense2 = expenseRepository.find(id);
		assertNotNull(expense2);
		assertNotNull(expense2.getUser());
		assertEquals("user name should match","katja",expense2.getUser().getName());
	}
	
	
}
