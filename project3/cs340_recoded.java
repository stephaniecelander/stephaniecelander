#!/user/bin/java
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
from bson import json_util

//insert doc into market db and stocks collection
MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
MongoDatabase database = mongoClient.getDatabase("market");
MongoCollection collection = database.getCollection("stocks");

//insert doc
new InsertOne<document>{
  try {
                collection.insertOne(document);
                System.out.println("Successfully inserted documents. \n");
            } catch (MongoWriteException mwe) {
                if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                    System.out.println("Document with that id already exists");
                }
            }
}

//insert multiple
writes.add{
new InsertOneModel<document>{}
new Document("Ticker", "A")
.append("Sector", "Healthcare")
.append("Country", "USA")
};

  System.out.println(myDocument);

//read doc
public class MongoReadAll {
public static void main(String[] args) {
try (MongoCursor < Document > cur = collection.find(){

                while (cur.hasNext()) {

                    var doc = cur.next();
                    var users = new ArrayList < > (doc.values());

                    System.out.printf(myDocument);
                }
            }
        }
    }
  
//update doc
public class MongodbFind {
 public static void main(String[] args) {
updateOperationDocument = new Document("$set", newValue);

 System.out.println(myDocument);
 

//delete doc
 public class MongoDeleteDocument {
 public static void main(String[] args) {
    collection.deleteOne("Ticker")
  
  System.out.println(string)
}
};

//search high to low
 public class MongoQueryDocument {
 public static void main(String[] args) {
    FindIterable<document> cursor = collection.find().sort(new query("50-Day Simple Moving Average",-1)).limit(5);
      MongoCursor<document> iterator = cursor.iterator();
        while(iterator.hasNext()) {
    System.out.println(iterator.next());
      }
    }
};
  
public class FindStr {

    public static Object FindString(String input) {

        //Get docs set up 
        Document doc1 = new Document("Industry", input);
        Document doc2 = new Document("Ticker", 1);

        //Set up find() command
        MongoCursor<Document> cursor = collection.find(doc1).projection(doc2).noCursorTimeout(true).iterator();

        //Print results
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }


        return cursor;
    }

}
]
  
public class Aggregate {

    public static Object AggregateDocument(String input) {

        //Get the docs set up for each section of the aggregate command
        //Set up Match
        Document match = new Document("$match", new Document("Sector", input));
        
        //Set up Project
        Document project1 = new Document("_id", 1);
        Document project2 = project1.append("Shares Outstanding", 1);
        Document project3 = project2.append("Industry", 1);
        Document project4 = project3.append("Sector", 1);
        Document project = new Document("$project", project4);
       
        //Set up Group
        Document group1 = new Document("_id", "$Industry");
        Document group2 = group1.append("Total Outstanding Shares", new Document("$sum", "$Shares Outstanding"));
        Document group = new Document("$group", group2);

        //Call the agg command
        AggregateIterable<Document> agg = collection.aggregate(Arrays.asList(match, project, group));

        //Print result
        for (Document printAggs : agg)
        {
            System.out.println(printAggs);
        }

        return agg;
    }
}
  
  