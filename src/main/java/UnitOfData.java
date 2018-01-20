import java.util.*;
public class UnitOfData {

    private HashMap<String, String> Datas;

    public UnitOfData(HashMap<String, String> ls) {
        Datas = ls;
    }
    public boolean boo(String str){
            if(str.equalsIgnoreCase("true")){
                return true;
            }else{
                if(str.equalsIgnoreCase("false")) {
                    return false;
                }else{
                    //throw new StringkeyOutOfBoundsException("WTF did you just input??? Srayan!!??");
                }
            }
            return false;
    }

    public HashMap<String, String> getDatas() {
        return Datas;
    }

    public void setDatas(HashMap<String, String> datas) {
        Datas = datas;
    }

    @Override
    public String toString() {
        return "UnitOfData{" +
                "Datas=" + Datas +
                '}';
    }
}