import com.yoctopuce.YoctoAPI.YGenericSensor;
import com.yoctopuce.YoctoAPI.YModule;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class WeightController {

    private YGenericSensor weightSensor;

    public WeightController(){
        weightSensor = YGenericSensor.FindGenericSensor("milivoltdevice.genericSensor1");

    }

    public String getWeight(){
        String value = null;
        if(isSensorValid()){
            try {
                value = String.valueOf(weightSensor.getSignalValue());
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }

    public boolean isSensorValid(){
        if(weightSensor == null || !weightSensor.isOnline()){
            return false;
        }
        return true;
    }


}
