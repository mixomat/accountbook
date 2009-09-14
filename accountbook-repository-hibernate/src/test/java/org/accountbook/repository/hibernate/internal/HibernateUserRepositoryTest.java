/**
 * 
 */
package org.accountbook.repository.hibernate.internal;

import static org.junit.Assert.*;

import java.util.List;

import org.accountbook.domain.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests wiring and access to user hibernate repository.
 * @author marc
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bundle-context-test.xml"})
public class HibernateUserRepositoryTest {

	@Autowired
	private HibernateUserRepository userRepository;
	
	@Test
	public void testFindByExample() throws Exception {
		User user = new User("test-user");
		userRepository.save(user);
		userRepository.flush();
		
		List<User> users = userRepository.findByExample(new User("test-user"));
		
		assertNotNull(users);
		assertEquals(1, users.size());
	}
}
