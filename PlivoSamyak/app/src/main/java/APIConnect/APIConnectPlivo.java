package APIConnect;

import android.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Samyak on 24-04-2015.
 */
public class APIConnectPlivo {
    public static boolean executePostCall(String to){
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://api.plivo.com/v1/Account/MAZDC5MTCXMMUZYZNLZG/Call/");
        post.setHeader("Authorization", "Basic " + Base64.encodeToString("MAZDC5MTCXMMUZYZNLZG:YjY4ZjE5ZDJkOTEwMjY2YzZjMTc2YjcyNDYwN2Fk".getBytes(), Base64.NO_WRAP));
        JSONObject request = new JSONObject();

        try {
            request.put("from", "919886689752");
            request.put("to", to);
            request.put("answer_url", "http://plivoapp.esy.es/plivosamyak.xml");
            request.put("answer_method", "GET");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(request.toString());
            stringEntity.setContentType("application/json");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        post.setEntity(stringEntity);
        HttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatusLine().getStatusCode() == 201) {
            return true;
        }
        return false;
    }
}
