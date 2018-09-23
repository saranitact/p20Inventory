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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DisplayInventory
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public DisplayInventory() {
	  //intentionally kept blank
  }
  public String strRname= null;
  public String strRltype= null;
  public String strRpurpose= null;
  public String strRlcount=  null;
  
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
    String name = request.getParameter("name");
    Boolean flag = true;
    
 

      if (name != null) 
      {
       		      		
   
       		if (DisplayInv(name, flag)!=true)
      {

        
        
  	  request.setAttribute("dmessage", "Search result not found");
      request.setAttribute("dsearchresults", null);
      rd.include(request, response);
      }
      
      else
      {
          
    	  request.setAttribute("dname", strRname);
          request.setAttribute("dlicensetype",strRltype);
          request.setAttribute("dpurpose",strRpurpose);
          request.setAttribute("dlicensecount", strRlcount);   
        
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


public boolean DisplayInv(String strname, Boolean bflag){
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
    
    String name = strname;
     
    BasicDBObject query = new BasicDBObject();
    
    query.put("name", name);
    DBCursor cursor = table.find(query);
     
    
    if (cursor.count() > 0) {
    	if (bflag == true){
    	BasicDBObject obj1= (BasicDBObject) table.findOne(query);
    	  strRname= obj1.get("name").toString();
    	  strRltype= obj1.get("licensetype").toString();
    	  strRpurpose= obj1.get("purpose").toString();
    	  strRlcount=  obj1.get("licensecount").toString();
    	}
    	return true;
    }
    else
    {
       	return false;
    }
}

}