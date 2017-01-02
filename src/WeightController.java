import com.yoctopuce.YoctoAPI.YGenericSensor;
import com.yoctopuce.YoctoAPI.YModule;

import java.util.ArrayList;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class WeightController {

    private YGenericSensor weightSensor;

    public WeightController(){
        weightSensor = YGenericSensor.FindGenericSensor("milivoltdevice.genericSensor1");

    }

    public void getWeight(ProductHandler ph){
        if(isSensorValid()){
            try {
                ph.setMilivolt(weightSensor.getSignalValue());
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isSensorValid(){
        if(weightSensor == null || !weightSensor.isOnline()){
            return false;
        }
        return true;
    }




}
