import java.util.*;
public class UnitOfData {

    private List<String> Datas;

    public UnitOfData(List<String> ls) {
        Datas = new ArrayList<String>(24);
        for(int i = 0; i < ls.size(); i++){
            Datas.add(ls.get(i));
        }
    }
    public boolean boo(String str){
            if(str.equalsIgnoreCase("true")){
                return true;
            }else{
                if(str.equalsIgnoreCase("false")) {
                    return false;
                }else{
                    throw new StringIndexOutOfBoundsException("WTF did you just input??? Srayan!!??");
                }
            }
    }

    public List<String> getDatas() {
        return Datas;
    }

    public void setDatas(List<String> datas) {
        Datas = datas;
    }

    @Override
    public String toString() {
        return "UnitOfData{" +
                "Datas=" + Datas +
                '}';
    }
}