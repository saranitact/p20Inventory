package com.devops.Inventory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayInventory
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public DisplayInventory() {
	  //intentionally kept blank
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
	  //intentionally kept blank
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("##### Your Action is initiated #######");
    
    String responsePage = "DisplayInventory.jsp";
    RequestDispatcher rd = request.getRequestDispatcher(responsePage);
    
    request.getRequestDispatcher("displayData.jsp");
    

    Mongo mongo = null;
    DB db = null;
    DBCollection table = null;
    mongo = new Mongo("localhost", 27017);
    
    db = mongo.getDB("BookstoreDB");
    table = db.getCollection("Inventory");
    
    String name = request.getParameter("name");
    
      BasicDBObject query = new BasicDBObject();
      if (name != null) 
      {
       		query.put("name", name);
        
      
     // DBCursor cursor = table.find(query);
       		BasicDBObject obj1= (BasicDBObject) table.findOne(query);
       		
   
       		if (obj1.isEmpty())
      {

        
        
  	  request.setAttribute("dmessage", "Search result not found");
      request.setAttribute("dsearchresults", null);
      rd.include(request, response);
      }
      
      else
      {
          
               request.setAttribute("dname", obj1.get("name").toString());
               request.setAttribute("dlicensetype",obj1.get("licensetype").toString());
               request.setAttribute("dpurpose",obj1.get("purpose").toString());
               request.setAttribute("dlicensecount", obj1.get("licensecount").toString());
        
           responsePage = "DisplayInventory.jsp";
           request.setAttribute("dmessage", "Your search is successful.");
           request.setAttribute("dsearchresults", "Search results returned");
           request.setAttribute("dfontcolor", "green");
           rd = request.getRequestDispatcher(responsePage);
           rd.include(request, response);
           rd = request.getRequestDispatcher(responsePage);
      }
    }
    else {
     
    	 request.setAttribute("dmessage", "Enter a value to search");
         rd.include(request, response);
    }
  }


public boolean DisplayInv(String strname){
  	Mongo mongo = null;
    DB db = null;
    DBCollection table = null;
    //Connect
    mongo = new Mongo("localhost", 27017);
    
    //set DB
    db = mongo.getDB("BookstoreDB");
    table = db.getCollection("Inventory");
    
    String name = strname;
     
    BasicDBObject query = new BasicDBObject();
    query.put("name", name);
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