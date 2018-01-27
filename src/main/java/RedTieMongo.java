import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Iterator;

public class RedTieMongo {
    private MongoClient mongo;
    private MongoDatabase database;
    private MongoCollection collection;
    private String d, c;
    public RedTieMongo(){
        mongo = Helper.getInstance();
        database = mongo.getDatabase("SERN");
        collection = database.getCollection("Steins;Gate");

    }

    public RedTieMongo(String d, String c) {
        this.d = d;
        this.c = c;
        mongo = Helper.getInstance();
        this.database = mongo.getDatabase(d);
        this.collection = database.getCollection(c);
    }

    public void readDatabase(){

        database = mongo.getDatabase(d);
        collection =  database.getCollection(c);
        System.out.println("Collection myCollection selected successfully");
        // Retrieving the documents after updation
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;

        // Getting the iterator
        Iterator it = iterDoc.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

    public JSONObject databaseJSON(){

        database = mongo.getDatabase(d);
        collection =  database.getCollection(c);
        System.out.println("CONVERSION START");
        // Retrieving the documents after updation
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        int c = 0;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        String s = "{\n" +
                "\t\"Data\": [\n";
        while (it.hasNext()) {
            Document doc = (Document) it.next();
            c++;
        }
        it = iterDoc.iterator();
        while (it.hasNext()) {
            JsonWriterSettings writerSettings = new JsonWriterSettings(JsonMode.SHELL, true);
            Document doc = (Document) it.next();
            s+=doc.toJson(writerSettings);
            if(!(i == c)) {
                s += ",";
            }
            s+="\n";
            i++;
        }
        s+="]\n" +
                "}";
        try {
            Object obj = new JSONParser().parse(s);
            //System.out.println(s);
            return (JSONObject) obj;
        }catch(Exception ex){
            System.out.println("It could not return the JSON created from the Database.");
        }
        return null;
    }

    public MongoClient getMongo() {
        return mongo;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(String db) {
        this.database  = mongo.getDatabase(db);
    }

    public MongoCollection getCollection() {
        return collection;
    }

    public void setCollection(String c) {
        this.collection = database.getCollection(c);
    }
}
