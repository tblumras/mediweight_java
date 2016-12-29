import com.yoctopuce.YoctoAPI.YDisplay;
import com.yoctopuce.YoctoAPI.YDisplayLayer;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class DisplayController {

    private YDisplay display;
    private YDisplayLayer displayLayer;
    private int displayWidth;
    private int displayHeight;

    public DisplayController(){
        display = YDisplay.FindDisplay("displaydevice.display");

        try{
            display.resetAll();
            displayWidth = display.get_displayWidth();
            displayHeight = display.get_displayHeight();
            displayLayer = display.get_displayLayer(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateDisplay(ProductHandler ph) {
        try {
            displayLayer.clear();
            displayLayer.moveTo(0, 5);
            displayLayer.lineTo(0, 0);
            displayLayer.lineTo(5, 0);
            displayLayer.moveTo(0, displayHeight - 6);
            displayLayer.lineTo(0, displayHeight - 1);
            displayLayer.lineTo(5, displayHeight - 1);
            displayLayer.moveTo(displayWidth - 1, displayHeight - 6);
            displayLayer.lineTo(displayWidth - 1, displayHeight - 1);
            displayLayer.lineTo(displayWidth - 6, displayHeight - 1);
            displayLayer.moveTo(displayWidth - 1, 5);
            displayLayer.lineTo(displayWidth - 1, 0);
            displayLayer.lineTo(displayWidth - 6, 0);

            displayLayer.selectFont("Large.yfm");
            displayLayer.drawText(displayWidth / 2, displayHeight / 2, YDisplayLayer.ALIGN.CENTER, String.valueOf(ph.getItemsOnWeight()));

            displayLayer.selectFont("Small.yfm");
            displayLayer.drawText(4, displayHeight-4 , YDisplayLayer.ALIGN.BOTTOM_LEFT, String.valueOf(ph.getMilivolt()) + " milivolts");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
