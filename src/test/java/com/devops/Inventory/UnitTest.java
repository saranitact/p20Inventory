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
		 		 assertEquals(true, new ProcessLogin().Login("tinks_2000@yahoo.com",  "pass"));
	 }
	 
	 
	 @Test
	   public void  testLoginFailure(){
		 //negative test case
	   	assertEquals(false, new ProcessLogin().Login("saran@a.com",  "saran"));
	    }
	 
	 @Test
	 public void  testDisplayInvSuccess(){ 
		 //positive test case
		 		 assertEquals(true, new DisplayInventory().DisplayInv("Ansible"));
	 }
	 
	 
	 @Test
	   public void  testDisplayInvFailure(){
		 //negative test case
	   	assertEquals(false, new DisplayInventory().DisplayInv("BugZilla"));
	    }
	

}

