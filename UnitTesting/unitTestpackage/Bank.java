package unitTestpackage;

import static org.junit.Assert.*;

import org.junit.Test;

import gamemodel.bankaccount.BankAccout;

public class Bank {

	@Test
	public void testSetBalance() {
		
		
		BankAccout bankaccount = new BankAccout(20);
		int before = (int) bankaccount.getBalance();
		
		BankAccout bankaccount1 = new BankAccout(200);
		
		int after = (int) bankaccount1.getBalance();
		
		assertNotNull(before);
		assertTrue(before != after);
		//fail("Not yet implemented");
	}

}
