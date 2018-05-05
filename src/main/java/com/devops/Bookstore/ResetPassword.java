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

public class ResetPassword
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public ResetPassword() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("##### Your Action is initiated #######");
    
    String responsePage = "fail.jsp";
    RequestDispatcher rd = request.getRequestDispatcher(responsePage);
    
    request.getRequestDispatcher("displayData.jsp");
    

    Mongo mongo = null;
    DB db = null;
    DBCollection table = null;
    mongo = new Mongo("localhost", 27017);
    
    db = mongo.getDB("BookstoreDB");
    table = db.getCollection("UserColl");
    
    String email = request.getParameter("email");
    String pwd1 = request.getParameter("newpassword");
    String pwd2 = request.getParameter("re-newpassword");
    





    if (pwd1.equals(pwd2)) {
      responsePage = "success.jsp";
      




      BasicDBObject query = new BasicDBObject();
      query.put("email", email);
      DBCursor cursor = table.find(query);
      if (cursor.count() > 0)
      {


        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("password", pwd1);
        
        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        
        table.update(query, updateObj);
        
        responsePage = "index.jsp";
        request.setAttribute("dmessage", "You password has been reset. Please signin with the new password.");
        request.setAttribute("dfontcolor", "green");
        rd = request.getRequestDispatcher(responsePage);
        rd.include(request, response);
        rd = request.getRequestDispatcher(responsePage);
      }
      else
      {
        request.setAttribute("demail", email);
        request.setAttribute("dmessage", "Email is not registered.");
        rd.include(request, response);
      }
    }
    else {
      request.setAttribute("demail", email);
      request.setAttribute("dmessage", "Passwords do not match!");
      rd.include(request, response);
    }
  }
}
