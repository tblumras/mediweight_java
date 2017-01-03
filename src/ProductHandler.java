import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class ProductHandler {

    private double milivolt;
    private int itemOnWeight;
    private ArrayList<VoltageRange> voltRanges;
    private LinkedList<Integer> readings;
    private int lastUpdatedAmount;
    private boolean hasOrdered;


    public ProductHandler(){
        milivolt = 0.0;
        itemOnWeight = 0;
        lastUpdatedAmount = 0;
        hasOrdered = true;
        readings = new LinkedList();
        voltRanges = new ArrayList();

        VoltageRange vr0 = new VoltageRange(0.0, 0.229, 0);
        VoltageRange vr1 = new VoltageRange(0.230, 0.350, 1);
        VoltageRange vr2 = new VoltageRange(0.351, 0.479, 2);
        VoltageRange vr3 = new VoltageRange(0.480, 0.589, 3);
        VoltageRange vr4 = new VoltageRange(0.590, 0.689, 4);
        VoltageRange vr5 = new VoltageRange(0.690, 0.813, 5);
        VoltageRange vr6 = new VoltageRange(0.814, 2.0, 6);

        voltRanges.add(vr0);
        voltRanges.add(vr1);
        voltRanges.add(vr2);
        voltRanges.add(vr3);
        voltRanges.add(vr4);
        voltRanges.add(vr5);
        voltRanges.add(vr6);
    }

    public void setMilivolt(double milivolt){
        this.milivolt = milivolt;
        for(VoltageRange vr : voltRanges){
            if(vr.isInRange(milivolt)){
                int vrAmount = vr.getAmount();
                readings.add(vrAmount);

                if(readings.size() > 4){
                    readings.poll();
                }

                int[] sortedReadings = new int[readings.size()];

                for(int i = 0; i < sortedReadings.length; i++){
                    sortedReadings[i] = readings.get(i);
                }

                Arrays.sort(sortedReadings);

                int[] countedReadings = new int[sortedReadings[sortedReadings.length-1]+1];
                for(int i = 0; i < countedReadings.length; i++){
                    countedReadings[i] = 0;
                }

                for(int i = 0; i < sortedReadings.length; i++){
                    int value = sortedReadings[i];
                    countedReadings[value]++;
                }

                int max = -1;
                int idx = -1;

                for(int i = 0; i < countedReadings.length; i++){
                    if(countedReadings[i] > max){
                        max = countedReadings[i];
                        idx = i;
                    }
                }

                itemOnWeight = idx;
            }
        }
    }

    public int getColorL1(){
        switch (itemOnWeight){
            case 0 :
                return 0x000000;
            case 1 :
                return 0x000000;
            case 2 :
                return 0x000000;
            default :
                return 0x00ff00;
        }
    }

    public int getColorL2(){
        switch (itemOnWeight){
            case 0:
                return 0xff0000;
            case 1:
                return 0xff8300;
            case 2 :
                return 0xffc700;
            case 3 :
                return 0xff6600;
            case 4 :
                return 0xf6ff00;
            case 5 :
                return 0xc3ff00;
            case 6 :
                return 0x00ff00;
            default :
                return 0x000000;
        }
    }


    public boolean shouldUpdateServer(){
        if(lastUpdatedAmount != itemOnWeight){
            lastUpdatedAmount = itemOnWeight;
            return true;
        }
        return false;
    }

   public boolean shouldOrderFromServer(){
       if(itemOnWeight <= 2 && !hasOrdered){
           hasOrdered = true;
           return true;
       }

       if(itemOnWeight > 2){
           hasOrdered = false;
       }

       return false;
    }

    public int getItemsOnWeight(){
        return itemOnWeight;
    }
    public double getMilivolt(){
        return milivolt;
    }
}
