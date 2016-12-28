/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class VoltageRange {

    private double min;
    private double max;
    private int amount;

    public VoltageRange(double min, double max, int amount){

        this.min = min;
        this.max = max;
        this.amount = amount;
    }

    public boolean isInRange(double voltage){

        if(voltage >= min && voltage <= max){
            return true;
        }
        return false;
    }

    public int getAmount(){
        return amount;
    }

}
