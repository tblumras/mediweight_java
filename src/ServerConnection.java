import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tina Rasmussen on 28-12-2016.
 */
public class ServerConnection {

    public ServerConnection(){

    }

    public boolean updateServer(ProductHandler ph){
        boolean sendResult = true;


        if(ph.shouldUpdateServer()){
            int items = ph.getItemsOnWeight();
            JsonWrapper jw = new JsonWrapper();
            jw.function = "update";
            jw.patientId = "0512115959";
            jw.prodId = "7";
            jw.instock = String.valueOf(items);
            sendResult = sendJw(jw);
        }

        if(ph.shouldOrderFromServer()){
            JsonWrapper jw = new JsonWrapper();
            jw.function = "order";
            jw.patientId = "0512115959";
            jw.prodId = "7";
            jw.amount = "6";
            sendResult = sendJw(jw);
        }

       return sendResult;
    }

    private boolean sendJw(JsonWrapper jw){
        Gson gson = new Gson();
        String json = gson.toJson(jw);
        System.out.println("json: " + json);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("json", json));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);

        HttpPost httppost = new HttpPost("http://mediweight.gnusys.dk/wp-content/plugins/mediweight_ws.php");
        httppost.setEntity(entity);
        HttpClient httpclient = HttpClients.createDefault();

        try {
            httpclient.execute(httppost);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }


}
