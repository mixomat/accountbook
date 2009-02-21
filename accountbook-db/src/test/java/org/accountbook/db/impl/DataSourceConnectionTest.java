/**
 * 
 */
package org.accountbook.db.impl;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author marc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/bundle-context.xml"})
public class DataSourceConnectionTest {

	private DataSource dataSource;
	
	@Test
	public void testDataSourceConnection() throws Exception {
		dataSource.getConnection();
	}
}
