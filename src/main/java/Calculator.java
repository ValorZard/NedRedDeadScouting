import java.util.Arrays;
import java.util.List;

public class Calculator {
    private int numTeams;
    private List<UnitOfData> unitsOfData;
    public Calculator(List<UnitOfData> unitsOfData){
        this.unitsOfData = unitsOfData;
        this.numTeams = unitsOfData.size();
    }
    public int numbTeams(String team){
        int num = 0;
        for(int i = 0; i < numTeams; i++){
            if(unitsOfData.get(i).getDatas().get(0) == team) {
                num++;
            }
        }
        return num;
    }

    public double average(int index){

        double sum = 0;
        for(int i  = 0; i < numTeams; i++){
            try {
                sum += Double.parseDouble(unitsOfData.get(i).getDatas().get(index));
            }
            catch (Exception ex){
                throw new NullPointerException("NORTH != UP!!!");
            }
        }
        return sum / numTeams;
    }

    public double average(int index, String team){
        int num = numbTeams(team);
        double sum = 0;
        for(int i  = 0; i < numTeams; i++){
            try {
                if(unitsOfData.get(i).getDatas().get(0) == team) {
                    sum += Double.parseDouble(unitsOfData.get(i).getDatas().get(index));
                }
            }
            catch (Exception ex){
                throw new NullPointerException("NORTH != UP!!!");
            }
        }
        return sum / num;
    }

    public double median(int index){
        double [] dataPieces = new double[numTeams];
        for (int i= 0; i < dataPieces.length; i++){
            try {
                dataPieces[i] = Double.parseDouble(unitsOfData.get(i).getDatas().get(index));
            }
            catch (Exception ex){
                throw new NullPointerException("WE ARE THE EXCEPTION!!! *Mongol Montage*");
            }
        }
        Arrays.sort(dataPieces);
        if (dataPieces.length % 2 != 0)
            return dataPieces[dataPieces.length / 2];

        else

            return (dataPieces[dataPieces.length / 2] + dataPieces[dataPieces.length / 2 + 1]) /2;

        //
    }

    public double median(int index, String team){
        int num = numbTeams(team);
        double [] dataPieces = new double[num];
        for (int i= 0; i < dataPieces.length; i++){
            try {
                if(unitsOfData.get(i).getDatas().get(0) == team) {
                    dataPieces[i] = Double.parseDouble(unitsOfData.get(i).getDatas().get(index));
                }
            }
            catch (Exception ex){
                throw new NullPointerException("WE ARE THE EXCEPTION!!! *Mongol Montage*");
            }
        }
        Arrays.sort(dataPieces);
        if (dataPieces.length % 2 != 0)
            return dataPieces[dataPieces.length / 2];

        else

            return (dataPieces[dataPieces.length / 2] + dataPieces[dataPieces.length / 2 + 1]) /2;

        //
    }

    public  double standardDeviation(int index){
        double average = average(index);
        double acc = 0;
        for (int i = 0; i < numTeams; i++){
            try {

                acc += Math.pow(Double.parseDouble(unitsOfData.get(i).getDatas().get(index)) - average, 2);
            }
            catch (Exception ex){
                System.out.println(ex);
                throw  new NullPointerException("We are exceptional");
            }

        }
        acc /= numTeams - 1;
        return Math.sqrt(acc);
    }

    public double standardDeviation(int index, String team){
        int num = numbTeams(team);
        double average = average(index, team);
        double acc = 0; //accumulate
        for (int i = 0; i < numTeams; i++){
            try {
                if(unitsOfData.get(i).getDatas().get(0) == team) {
                    acc += Math.pow(Double.parseDouble(unitsOfData.get(i).getDatas().get(index)) - average, 2);
                }
            }
            catch (Exception ex){
                System.out.println(ex);
                throw  new NullPointerException("We are exceptional");
            }

        }
        acc /= num - 1;
        return Math.sqrt(acc);
    }

    public double mode(int index){
        double maxValue = 0.0, maxCount = 0.0;
        for (int i = 0; i < numTeams; ++i) {
            int count = 0;
            for (int j = 0; j < numTeams; ++j) {
                if (Double.parseDouble(unitsOfData.get(i).getDatas().get(index)) == Double.parseDouble(unitsOfData.get(i).getDatas().get(index))) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = Double.parseDouble(unitsOfData.get(i).getDatas().get(index));
            }
        }

        return maxValue;
    }

    public double mode(int index, String team){
        int num = numbTeams(team);
        double maxValue = 0.0, maxCount = 0.0;
        for (int i = 0; i < numTeams; ++i) {
            int count = 0;
            if(unitsOfData.get(i).getDatas().get(0) == team) {
                for (int j = 0; j < numTeams; ++j) {
                    if (unitsOfData.get(i).getDatas().get(0) == team) {
                        if (Double.parseDouble(unitsOfData.get(i).getDatas().get(index)) == Double.parseDouble(unitsOfData.get(i).getDatas().get(index)))
                            ++count;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = Double.parseDouble(unitsOfData.get(i).getDatas().get(index));
                }
            }
        }

        return maxValue;
    }
}
