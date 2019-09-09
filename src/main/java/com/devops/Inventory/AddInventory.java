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




public class AddInventory
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public AddInventory() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("##### Your Action is initiated #######");
    
    String responsePage = "Inventory.jsp";
    

    request.getRequestDispatcher("displayData.jsp");
    



    
    String name = request.getParameter("name");
    String licensetype = request.getParameter("licensetype");
    String purpose = request.getParameter("purpose");
    String licensecount = request.getParameter("licensecount");
    

    if ((name != null) && (licensetype != null) && (purpose != null))
    {
    	
     
      if (AddInv(name,licensetype, purpose, licensecount ) != true)
      {
        request.setAttribute("dmessage", "This tool is already available.");
        RequestDispatcher rd = request.getRequestDispatcher(responsePage);
        rd.include(request, response);
        rd = request.getRequestDispatcher(responsePage);
      }
      else
      {
        
        responsePage = "Inventory.jsp";
        request.setAttribute("dmessage", "Tool has been added.");
        request.setAttribute("dfontcolor", "green");
        RequestDispatcher rd = request.getRequestDispatcher(responsePage);
        rd.include(request, response);
        rd = request.getRequestDispatcher(responsePage);
      }
      

    }
    else
    {
      if (name == null) {
        request.setAttribute("dmessage", "Please enter tool name.");
      }
      
      if (licensetype == null) {
        request.setAttribute("dmessage", "Please enter license type.");
      }
      
      if (purpose == null) {
        request.setAttribute("dmessage", "Please enter purpose.");
      }
      
          
      RequestDispatcher rd = request.getRequestDispatcher(responsePage);
      rd.include(request, response);
      rd = request.getRequestDispatcher(responsePage);
    }
  }

//Add Inv
public boolean AddInv(String strname, String strlicensetype, String strpurpose, String strlicensecount){
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
    
    
    //set DB
     
    db = mongo.getDB("BookstoreDB");
    table = db.getCollection("Inventory");
    
    // double number= Math.random();
   // String name = strname + number;
    String name = strname;
    BasicDBObject query = new BasicDBObject();
    query.put("name", name);
    DBCursor cursor = table.find(query);
    if (cursor.count() > 0) {
    	return false;
    }
    else
    {
    	 BasicDBObject newDocument = new BasicDBObject();
         newDocument.put("name", name);
         newDocument.put("licensetype", strlicensetype);
         newDocument.put("purpose", strpurpose);
         newDocument.put("licensecount", strlicensecount);
         
         table.insert(new DBObject[] { newDocument });
    	
    	return true;
    }
	}
}

/*public long multiply(int a,int b){
	return a*b;
}*/


