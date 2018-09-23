package com.devops.Inventory;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    String ip= null;
    
    try
    {
 	   JSONParser parser = new JSONParser();
       
 	   /*File currentDir = new File(".");
 	    File parentDir = currentDir.getParentFile();
 	    File newFile = new File(parentDir,"Inventory.json");*/
 	   
 	   File directory = new File("./");
 	   System.out.println("###########  Current Dir: ############" + directory.getAbsolutePath());
    
 	   File file = new File("conf//Inventory.json");
 	   String path = file.getAbsolutePath();
 	   System.out.println("############  Value of file path is:   ############" + path);	   
         Object obj = parser.parse(new FileReader(file));

         JSONObject jsonObject =  (JSONObject) obj;
         
         
         //parse json
        JSONArray mongoconn = (JSONArray) jsonObject.get("mongoconn");

         for (Object objmongoconn : mongoconn) {
             JSONObject jsonmongoconn = (JSONObject) objmongoconn;
             ip = (String) jsonmongoconn.get("ip");
           }

        //  ip = (String) jsonObject.get("ip");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        System.out.println("############  FileNotFoundException:   ############");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("############  IOException:   ############");
    } catch (ParseException e) {
        e.printStackTrace();
        System.out.println("############  ParseException:   ############");
    }
      //end code for reading json file   
     mongo = new Mongo(ip, 27017);
     System.out.println("############  Value of ip is:   ############" + ip);
   // mongo = new Mongo("localhost", 27017);
    
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
