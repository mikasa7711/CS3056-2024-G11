package tests;

import java.util.Date;

import model.Account;

public class AccountTest {
	
	public static void testConstructor() {
	 String test_account_number = "37";
	 String test_username_of_account_holder = "mike";
	 String test_account_type = "standard";
	 Date test_account_opening_date = new Date(2009, 11, 11);
		
	 Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, test_account_opening_date);
		
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		
		System.out.println("All java assertions for getters in the test suite passed(none failed)");
	}
	
	
	public static void testSetters() {
		 String test_account_number = "37";
		 String test_username_of_account_holder = "mike";
		 String test_account_type = "standard";
		 Date test_account_opening_date = new Date(2009, 11, 11);
			
		 Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type, test_account_opening_date); 
		 
		testAccount.setAccount_number(test_account_number);
		    assert testAccount.getAccount_number().equals(test_account_number);	
		    
		 testAccount.setUsername_of_account_holder(test_username_of_account_holder);
			assert testAccount.getUsername_of_account_holder().equals(test_username_of_account_holder);
			    
		 testAccount.setAccount_type(test_account_type);
		    assert testAccount.getAccount_type().equals(test_account_type);
		    
		 testAccount.setAccount_opening_date(test_account_opening_date);
		    assert testAccount.getAccount_opening_date().equals(test_account_opening_date);
		    
		    System.out.println("All java assertions for setters in the test suite passed(none failed)");
	}
	
	public static void main(String[] args) {
		testConstructor();
		testSetters();
	}
}
