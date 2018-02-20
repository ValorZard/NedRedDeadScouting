
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.*;

public class Driver {

    public static void main(String[] args) {
        // parsing file "JSONExample.json"
        ArrayList<UnitOfData> unitsOfData = new ArrayList<UnitOfData>();
        Scanner scan = new Scanner(System.in);
        ReadMit r = new ReadMit();
        try {
            Object obj = new JSONParser().parse(r.getFile());

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            JSONArray ja = (JSONArray) jo.get("Data");

            for (Object o : ja) {
                Map map = (Map) o;
                HashMap<String, String> hmap = new HashMap<String, String>();
                for (Object m : map.entrySet()) {
                    Entry e = (Entry) m;
                    //System.out.println(e.getKey() + " " + (String) (e.getValue()));
                    hmap.put((String) (e.getKey()), (String) (e.getValue()));
                }
                UnitOfData u = new UnitOfData(hmap);
                unitsOfData.add(u);
            }
            Calculator calc = new Calculator(unitsOfData);
            while (true) {
                scan = new Scanner(System.in);
                System.out.println("WHAT DO YOU WANT TO AVERAGE?????/*???????*/");
                String s = scan.nextLine();
                System.out.println(calc.average(s, "1458"));
                System.out.println("Do you wanna do MongoDB");
                scan = new Scanner(System.in);
                s = scan.nextLine();
                if (s.equalsIgnoreCase("yes")) {
                    App app = new App();
                    jo = app.run();
                }
                ja = (JSONArray) jo.get("Data");
                System.out.println("----------------------------------------------------------");
                try (FileWriter file = new FileWriter("test.json")) {
                    file.write(jo.toJSONString());
                    file.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (Object o : ja) {
                    Map map = (Map) o;
                    for (Object m : map.entrySet()) {
                        Entry e = (Entry) m;
                        System.out.println(e.getKey() + " " + e.getValue());
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("It didnt work! REEEEEEEEEEE");
        }

    }

}
