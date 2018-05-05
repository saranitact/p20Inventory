package com.devops.Bookstore;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
 

public class UnitTest
{
	//Unit Test Cases

	 @Test
	 public void  testLoginSuccess(){
    	//assertEquals(true, new ProcessLogin().Login("saran@a.com",  "saran@a.com"));
		 
		 assertEquals(true, new ProcessLogin().Login("tinks_2000@yahoo.com",  "pass"));
	 }
	 @Test
	   public void  testLoginFailure(){
	   	assertEquals(false, new ProcessLogin().Login("saran@a.com",  "saran"));
	    }
	
	//assertTrue(true);

}

