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
//for json file 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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
    
   //x Mongo mongo = null;
   //x DB db = null;
   //x DBCollection table = null;
    //xString ip= null;
     
    
    String responsePage = "index.jsp";
    RequestDispatcher rd = request.getRequestDispatcher(responsePage);
    
    request.getRequestDispatcher("displayData.jsp");
    //Get data
    String email = request.getParameter("email");
    String pwd = request.getParameter("password");
    

    if (Login(email, pwd) == true) {
    	//is successful goto success.jsp
      responsePage = "Home.jsp";
      rd = request.getRequestDispatcher(responsePage);
      rd.include(request, response);
    }
    else
    {
      request.setAttribute("dfontcolor", "red");
      //Error message below
      request.setAttribute("dmessage", "Sorry Incorrect UserName or Password!");
      rd.include(request, response);
    }
  }
  //Mongo DB
  public boolean Login(String strEmail, String strPwd){
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
	    
	    //Connect
	     mongo = new Mongo(ip, 27017);
	     System.out.println("############  Value of ip is:   ############" + ip);   // mongo = new Mongo("localhost", 27017);
	     
	    //set DB
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


