package unitTestpackage;

import static org.junit.Assert.*;


import org.junit.Test;

import gamemodel.bankaccount.BankAccout;

/**
 * Teasing setting the player Balance
 *@author m_lzahra
 *@version 1.0
 *@since 16/2/2016
 */
public class Bank {

	/**
	 *Teasing setting the player Balance 
	 */
	@Test
	public void testSetBalance() {
		
		
		BankAccout bankAccount = new BankAccout(20);
		int before = (int) bankAccount.getBalance();
		
		BankAccout bankAccount2 = new BankAccout(200);
		int after = (int) bankAccount2.getBalance();
		
		assertNotNull(before);
		assertTrue(before != after);

	}

}
