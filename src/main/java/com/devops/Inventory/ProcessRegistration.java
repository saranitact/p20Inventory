package com.devops.Inventory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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



public class ProcessRegistration
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public ProcessRegistration() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("##### Your Action is initiated #######");
    
    String responsePage = "fail.jsp";
    

    request.getRequestDispatcher("displayData.jsp");
    

    Mongo mongo = null;
    DB db = null;
    DBCollection table = null;
    //code for reading json file
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
    
    db = mongo.getDB("BookstoreDB");
    table = db.getCollection("UserColl");
    
    String name = request.getParameter("username");
    String pwd = request.getParameter("password");
    String email = request.getParameter("email");
    String domain = request.getParameter("domain");
    

    if ((name != null) && (pwd != null) && (email != null) && (domain != null))
    {
      BasicDBObject query = new BasicDBObject();
      query.put("email", email);
      
      DBCursor cursor = table.find(query);
      if (cursor.count() > 0)
      {
        request.setAttribute("dmessage", "This email is already registered.");
        RequestDispatcher rd = request.getRequestDispatcher(responsePage);
        rd.include(request, response);
        rd = request.getRequestDispatcher(responsePage);
      }
      else
      {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", name);
        newDocument.put("password", pwd);
        newDocument.put("email", email);
        newDocument.put("domain", domain);
        
        table.insert(new DBObject[] { newDocument });
        responsePage = "index.jsp";
        request.setAttribute("dmessage", "You have been registered. Please signin.");
        request.setAttribute("dfontcolor", "green");
        RequestDispatcher rd = request.getRequestDispatcher(responsePage);
        rd.include(request, response);
        rd = request.getRequestDispatcher(responsePage);
      }
      

    }
    else
    {
      if (name == null) {
        request.setAttribute("dmessage", "Please enter username");
      }
      
      if (pwd == null) {
        request.setAttribute("dmessage", "Please enter password");
      }
      
      if (email == null) {
        request.setAttribute("dmessage", "Please enter email");
      }
      
      if (domain == null) {
        request.setAttribute("dmessage", "Please enter domain");
      }
      
      RequestDispatcher rd = request.getRequestDispatcher(responsePage);
      rd.include(request, response);
      rd = request.getRequestDispatcher(responsePage);
    }
  }
}

/*public long multiply(int a,int b){
	return a*b;
}*/
