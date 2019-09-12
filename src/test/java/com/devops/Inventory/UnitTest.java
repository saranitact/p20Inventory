package com.devops.Inventory;

import static org.junit.Assert.*;
import org.junit.Test;

import com.devops.Inventory.ProcessLogin;
import com.devops.Inventory.DisplayInventory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
 

public class UnitTest
{
	//Unit Test Cases for login screen

	 @Test
	 public void  testLoginSuccess(){
     //positive test case
		 		 assertEquals(true, new ProcessLogin().Login("a@b.com",  "pass"));
	 }
	 
	 
	 @Test
	   public void  testLoginFailure(){
		 //negative test case
	   	assertEquals(false, new ProcessLogin().Login("c@d.com",  "pass"));
	    }
	 
	 @Test
	 public void  testDisplayInvSuccess(){ 
		 //positive test case
		 		 assertEquals(true, new DisplayInventory().DisplayInv("Ansible", false));
	 }
	 
	 
	 @Test
	   public void  testDisplayInvFailure(){
		 //negative test case
	   	assertEquals(false, new DisplayInventory().DisplayInv("BugZilla", false));
	    }
	
	 @Test
	 public void  testAddInvSuccess(){ 
		 double number= Math.random();
		 String newname= "Testtool" + number;
		 //positive test case
		 		 assertEquals(true, new AddInventory().AddInv(newname, "Open Source", "test", "0"));
	 }
	 
	 @Test
	 public void  testAddInvFailure(){ 
		 String newname= "Ansible";
		 //negative test case
		 		 assertEquals(false, new AddInventory().AddInv(newname, "Open Source", "deployment", "0"));
	 }
}

