import com.sun.org.apache.xpath.internal.operations.String;
import com.yoctopuce.YoctoAPI.YColorLed;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class LEDController {
    private YColorLed colorled1;
    private YColorLed colorled2;


    public LEDController(){
        colorled1 = YColorLed.FindColorLed("leddevice.colorLed1");
        colorled2 = YColorLed.FindColorLed("leddevice.colorLed2");
        }

    public void updateLed(ProductHandler ph){

        try{
            colorled1.set_rgbColor(ph.getColorL1());
            colorled2.set_rgbColor(ph.getColorL2());
        }catch (Exception e){
            System.out.println(e);
        }





       /*
        int color_red[] = {0xff0000};
        int color_green[] = {0x00ff00};
        int color_blue[] = {0x0000ff};
*/
    }
}
