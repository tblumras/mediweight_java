/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class Starter {

    public static void main(String[] args){
        System.out.println("Hello World");
        EventLoop eventloop = new EventLoop();
        eventloop.runEvent(true);
    }


}
