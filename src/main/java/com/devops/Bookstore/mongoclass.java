package com.devops.Bookstore;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

//Setup connection with Mongodb, create BookstoreDB db and UserColl collection.
public class mongoclass
{
  public mongoclass() {}
  
  public static void main(String[] args) throws java.net.UnknownHostException
  {
    Mongo mongo = null;
    com.mongodb.DB db = null;
    DBCollection table = null;
    mongo = new Mongo("localhost", 27017);
    
    db = mongo.getDB("BookstoreDB");
    table = db.getCollection("UserColl");
    
    table.drop();
    
  //List all databases
    System.out.println("Databases:");
    List<String> dbs= mongo.getDatabaseNames();
    for (String dbset: dbs)
    {
    	System.out.println(dbset);
    }
    //Collections from a database
    System.out.println("\nCollections");
    db=mongo.getDB("local");
    Set<String> tables= db.getCollectionNames();
    for (String coll : tables)
    {
    	System.out.println(coll);
    }
    //Create documents and insert test data
    
    BasicDBObject document1 = new BasicDBObject();
    document1.put("name", "Anna");
    document1.put("password", "pass");
    document1.put("email", "a@b.com");
    document1.put("domain", "Continuous Integration");
    
    BasicDBObject document2 = new BasicDBObject();
    document2.put("name", "Kane");
    document2.put("password", "pass");
    document2.put("email", "a@b.com");
    document2.put("domain", "Continuous Integration");
    
    table.insert(new com.mongodb.DBObject[] { document1 });
    table.insert(new com.mongodb.DBObject[] { document2 });
    

    System.out.println("\nDaten der Collection: ");
    BasicDBObject searchquery = new BasicDBObject();
    com.mongodb.DBCursor cursor = table.find(searchquery);
    
    while (cursor.hasNext()) {
      System.out.println(cursor.next());
    }
  }
}
