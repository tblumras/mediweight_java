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

        VoltageRange vr1 = new VoltageRange(0.23, 0.350, 1);
        VoltageRange vr2 = new VoltageRange(0.351, 0.479, 2);
        VoltageRange vr3 = new VoltageRange(0.480, 0.589, 3);
        VoltageRange vr4 = new VoltageRange(0.590, 0.689, 4);
        VoltageRange vr5 = new VoltageRange(0.690, 0.813, 5);
        VoltageRange vr6 = new VoltageRange(0.814, 0.952, 6);

        voltRanges.add(vr1);
        voltRanges.add(vr2);
        voltRanges.add(vr3);
        voltRanges.add(vr4);
        voltRanges.add(vr5);
        voltRanges.add(vr6);
    }

    public void setMilivolt(double milivolt){
        this.milivolt = milivolt;
        System.out.println("" + milivolt);
        for(VoltageRange vr : voltRanges){
            if(vr.isInRange(milivolt)){
                itemOnWeight = vr.getAmount();
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

    public int getItemsOnWeight(){
        return itemOnWeight;
    }
    public double getMilivolt(){
        return milivolt;
    }
}
