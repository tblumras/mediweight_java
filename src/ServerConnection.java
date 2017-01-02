import com.google.gson.Gson;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class ServerConnection {

    public ServerConnection(){

    }

    public boolean updateServer(ProductHandler ph){
       // if(ph.shouldUpdateServer()){
         if(true){
            int items = ph.getItemsOnWeight();
            JsonWrapper jw = new JsonWrapper();
            jw.function = "update";
            jw.patientId = "0512115959";
            jw.prodId = "10";
            jw.instock = String.valueOf(items);
            sendJw(jw);
        }
        return true;
    }

    private boolean sendJw(JsonWrapper jw){

        Gson gson = new Gson();
        String json = gson.toJson(jw);
        System.out.println("json: " + json);

        return true;
    }


}
