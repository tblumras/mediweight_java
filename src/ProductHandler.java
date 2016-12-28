import java.util.ArrayList;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class ProductHandler {

    private double milivolt;
    private int itemOnWeight;
    private ArrayList<VoltageRange> voltRanges;


    public ProductHandler(){
        milivolt = 0.0;
        itemOnWeight = 0;

        voltRanges = new ArrayList();

        VoltageRange vr1 = new VoltageRange(0.23, 0.33, 1);
        VoltageRange vr2 = new VoltageRange(0.36, 0.46, 2);
        VoltageRange vr3 = new VoltageRange(0.49, 0.52, 3);
        VoltageRange vr4 = new VoltageRange(0.60, 0.65, 4);
        VoltageRange vr5 = new VoltageRange(0.68, 0.76, 5);
        VoltageRange vr6 = new VoltageRange(0.80, 0.90, 6);

        voltRanges.add(vr1);
        voltRanges.add(vr2);
        voltRanges.add(vr3);
        voltRanges.add(vr4);
        voltRanges.add(vr5);
        voltRanges.add(vr6);
    }

    public void setMilivolt(double milivolt){
        this.milivolt = milivolt;
        //System.out.println("" + milivolt);
        for(VoltageRange vr : voltRanges){
            if(vr.isInRange(milivolt)){
                itemOnWeight = vr.getAmount();
            }
        }
    }

    public int getItemsOnWeight(){
        return itemOnWeight;
    }
}
