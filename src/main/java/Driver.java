import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.*;
public class Driver {

    public static void main(String[] args){
        // parsing file "JSONExample.json"
        ArrayList<UnitOfData> unitsOfData = new ArrayList<UnitOfData>();
        ReadMit r = new ReadMit();
        try{
            Object obj = new JSONParser().parse(r.getFile());

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            JSONArray ja = (JSONArray) jo.get("Data");

            for(Object o : ja){
                Map map = (Map) o;
                ArrayList<String> a = new ArrayList<String>();
                for(Object m : map.entrySet()){
                    Entry e = (Entry) m;
                    System.out.println(e.getKey()+" "+(String)(e.getValue()));
                    a.add((String)e.getValue());
                }
                UnitOfData u = new UnitOfData(a);
                unitsOfData.add(u);
            }
            Calculator calc = new Calculator(unitsOfData);
            System.out.println(calc.average(4));
    }
        catch(Exception ex){
            System.out.println("It didnt work! REEEEEEEEEEE");
        }

    }

}
