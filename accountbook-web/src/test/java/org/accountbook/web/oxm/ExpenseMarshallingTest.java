package org.accountbook.web.oxm;


import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.accountbook.domain.model.Expense;
import org.accountbook.web.ExpenseList;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public class ExpenseMarshallingTest {
	
	private static Logger logger = LoggerFactory.getLogger(ExpenseMarshallingTest.class);

	@Autowired
	private Marshaller marshaller;
	
	@Test
	public void testMarshalling() throws Exception {
		List<Expense> expenses = new ArrayList<Expense>();
		expenses.add(createTestExpense());
		expenses.add(createTestExpense());
		ExpenseList expenseList = new ExpenseList(expenses);
		
		String resultXml = marshall(expenseList);
		
		assertNotNull(resultXml);
	}

	private String marshall(ExpenseList expenseList) throws IOException {
		OutputStream outputStream = new ByteArrayOutputStream();
		Result result = new StreamResult(outputStream);
		marshaller.marshal(expenseList, result);
		
		logger.info(outputStream.toString());
		return outputStream.toString();
	}

	private Expense createTestExpense() {
		Expense expense = new Expense();
		expense.setAmount(2390.4);
		expense.setDescription("test expense for marshalling");
		return expense;
	}
}
