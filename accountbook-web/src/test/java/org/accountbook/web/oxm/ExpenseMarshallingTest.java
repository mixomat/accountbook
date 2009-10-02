package org.accountbook.web.oxm;


import static org.junit.Assert.*;

import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.accountbook.domain.model.Expense;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public class ExpenseMarshallingTest {

	@Autowired
	private Marshaller marshaller;
	
	@Test
	public void testMarshalling() throws Exception {
		assertNotNull(marshaller);
		OutputStream outputStream = new ByteArrayOutputStream();
		Result result = new StreamResult(outputStream );
		marshaller.marshal(new Expense(), result);
		System.out.println(outputStream.toString());
		
	}
}
