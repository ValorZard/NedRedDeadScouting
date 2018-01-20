
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;
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
                HashMap<String, String> hmap = new HashMap<String, String>();
                for(Object m : map.entrySet()){
                    Entry e = (Entry) m;
                    System.out.println(e.getKey()+" "+(String)(e.getValue()));
                   hmap.put((String) (e.getKey()), (String) (e.getValue()));
                }
                UnitOfData u = new UnitOfData(hmap);
                unitsOfData.add(u);
            }
            Calculator calc = new Calculator(unitsOfData);
            while(true){
                Scanner scan = new Scanner(System.in);
                System.out.println("WHAT DO YOU WANT TO AVERAGE?????/*???????*/");
                String s = scan.nextLine();
                System.out.println(calc.average(s));
            }
    }
        catch(Exception ex){
            System.out.println("It didnt work! REEEEEEEEEEE");
        }

    }

}
