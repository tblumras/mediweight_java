import com.yoctopuce.YoctoAPI.*;

import java.util.concurrent.TimeUnit;


/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class EventLoop {

    private boolean isRunning;
    private WeightController wc;
    private DisplayController dc;
    private LEDController lc;


    public EventLoop(){
        isRunning = false;

        try {
            // setup the API to use local VirtualHub
            YAPI.RegisterHub("127.0.0.1");
        } catch (YAPI_Exception ex) {
            System.out.println("Cannot contact VirtualHub on 127.0.0.1 (" + ex.getLocalizedMessage() + ")");
            System.out.println("Ensure that the VirtualHub application is running");
            System.exit(1);
        }

        wc = new WeightController();
        dc = new DisplayController();
        lc = new LEDController();
    }

    public void runEvent(boolean startRun) {
        isRunning = startRun;


        while (isRunning) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if(wc.isSensorValid()){
                ProductHandler ph = wc.getWeight();
                dc.updateDisplay(ph);
                lc.updateLed(ph);
            }else{
                System.out.println("Sensor is not valid");
            }
        }
    }
}
