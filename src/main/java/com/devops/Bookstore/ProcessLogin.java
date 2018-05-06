package com.devops.Bookstore;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProcessLogin
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  //process Login info
  public ProcessLogin() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("##### Your Action is initiated #######");
    
    Mongo mongo = null;
    DB db = null;
    DBCollection table = null;
    mongo = new Mongo("localhost", 27017);
    
    //Create DB
    db = mongo.getDB("BookstoreDB");
    //Create Collection
    table = db.getCollection("UserColl");
    
    String responsePage = "index.jsp";
    RequestDispatcher rd = request.getRequestDispatcher(responsePage);
    
    request.getRequestDispatcher("displayData.jsp");
    //Get data
    String email = request.getParameter("email");
    String pwd = request.getParameter("password");
    
    //Load data
    BasicDBObject query = new BasicDBObject();
    query.put("email", email);
    query.put("password", pwd);
    //Fetch data
    DBCursor cursor = table.find(query);
    //If found
    if (cursor.count() > 0) {
    	//is successful goto success.jsp
      responsePage = "success.jsp";
      rd = request.getRequestDispatcher(responsePage);
      rd.include(request, response);
    }
    else
    {
      request.setAttribute("dfontcolor", "red");
      request.setAttribute("dmessage", "Sorry Incorrect UserName or Password!");
      rd.include(request, response);
    }
  }
  
  public boolean Login(String strEmail, String strPwd){
	  	Mongo mongo = null;
	    DB db = null;
	    DBCollection table = null;
	    mongo = new Mongo("localhost", 27017);
	    
	    db = mongo.getDB("BookstoreDB");
	    table = db.getCollection("UserColl");
	    
	    String email = strEmail;
	    String pwd = strPwd;
	    
	    BasicDBObject query = new BasicDBObject();
	    query.put("email", email);
	    query.put("password", pwd);
	    DBCursor cursor = table.find(query);
	    if (cursor.count() > 0) {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}

}


