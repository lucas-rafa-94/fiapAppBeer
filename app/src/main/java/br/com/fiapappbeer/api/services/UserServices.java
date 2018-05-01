package br.com.fiapappbeer.api.services;

import android.util.Log;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

import br.com.fiapappbeer.api.models.User;

/**
 * Created by lucasdossantos on 4/29/18.
 */

public class UserServices {

    private static ClientResponse response = null;
    private static WebResource webResource = null;
    private static Client client = null;

    final static String URI = "https://fiapappbeercassandra.herokuapp.com/users/";

    public static int validaLogin(String email, String password){
        int responseCode = 0;
        client = Client.create();
        try{
            webResource = client.
                    resource(URI + "find")
                    .queryParam("email", email)
                    .queryParam("password", password);
            response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(ClientResponse.class);
            responseCode = response.getStatus();
        } catch (Exception e) {
        //    close();
            e.printStackTrace();
            responseCode = 500;
        }
        //close();
        return responseCode;
    }

    public static String criaUsuario(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user).toString();
        client = Client.create();
        try{
            webResource = client.
                    resource(URI + "insert");
            response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).header("Content-type","application/json")
                    .post(ClientResponse.class, json);
            Log.e("Login", String.valueOf(response.getStatus()));
        } catch (Exception e) {
          //  close();
            e.printStackTrace();
        }
        //close();
        return null;
    }


}
