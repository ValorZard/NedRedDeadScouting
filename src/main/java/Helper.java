import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Helper {
    private static MongoClient m = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

    public static MongoClient getInstance(){
        return m;
    }

}
