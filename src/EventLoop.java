import com.yoctopuce.YoctoAPI.*;


/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class EventLoop {

    private boolean isRunning;
    private WeightController wc;


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
    }

    public void runEvent(boolean startRun) {
        isRunning = startRun;


        while (isRunning) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if(wc.isSensorValid()){
                String currentValue = wc.getWeight();
                System.out.println(currentValue);
            }else{
                System.out.println("Sensor is not valid");
            }

        }
    }
}
