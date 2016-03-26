package testingUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.bankaccount.BankAccount;


/**
 * Teasing setting the player Balance
 *@author m_lzahra
 *@version 1.0
 *@since 16/2/2016
 */
public class Bank {


	private BankAccount bankAccount;
	private double  afterSetting;
	private double beforeSetting;
	
	/**
	 * setting values 
	 */
	@Before 
	public void setValues(){
		
		bankAccount = new BankAccount();
	}
	
	/**
	 *Teasing setting the player Balance 
	 */
	@Test
	public void testSetBalance() {
		
	    beforeSetting = bankAccount.getBalance();
		bankAccount.setBalance(100);
		
	    afterSetting =  bankAccount.getBalance() ;
	
		assertTrue(beforeSetting < afterSetting );

	}
	
	@Test
	public void testdeposit(){
	    beforeSetting = bankAccount.getBalance();
		bankAccount.deposit(100);
	    afterSetting =  bankAccount.getBalance() ;
		assertTrue(beforeSetting < afterSetting );
	}
	
	@Test
	public void testdffff(){
		
		bankAccount.setBalance(100);
		beforeSetting = bankAccount.getBalance();
		
		bankAccount.withDraw(20);
		afterSetting =  bankAccount.getBalance() ;
		
		assertTrue(beforeSetting > afterSetting );
		
	}
	
	

}
