import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    private static MongoClient m = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

    public static MongoClient getInstance(){
        return m;
    }
    public static String getResourcePath() {
        try {
            Charset charset = Charset.forName("UTF-8");
            URI resourcePathFile = System.class.getResource("/RESOURCE_PATH").toURI();
            String resourcePath = Files.readAllLines(Paths.get(resourcePathFile), charset).get(0);
            URI rootURI = new File("").toURI();
            URI resourceURI = new File(resourcePath).toURI();
            URI relativeResourceURI = rootURI.relativize(resourceURI);
            return relativeResourceURI.getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
