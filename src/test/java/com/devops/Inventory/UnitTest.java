package com.devops.Inventory;

import static org.junit.Assert.*;
import org.junit.Test;

import com.devops.Inventory.ProcessLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
 

public class UnitTest
{
	//Unit Test Cases

	 @Test
	 public void  testLoginSuccess(){
    	//assertEquals(true, new ProcessLogin().Login("saran@a.com",  "saran@a.com"));
		 //positive test case
		 		 assertEquals(true, new ProcessLogin().Login("tinks_2000@yahoo.com",  "pass"));
	 }
	 @Test
	   public void  testLoginFailure(){
		 //negative test case
	   	assertEquals(false, new ProcessLogin().Login("saran@a.com",  "saran"));
	    }
	
	//assertTrue(true);

}

