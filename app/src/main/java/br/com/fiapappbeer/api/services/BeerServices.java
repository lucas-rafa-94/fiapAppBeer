package br.com.fiapappbeer.api.services;

import android.util.Log;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import br.com.fiapappbeer.api.models.Beer;

/**
 * Created by lucasdossantos on 5/1/18.
 */

public class BeerServices {

    private static ClientResponse response = null;
    private static WebResource webResource = null;
    private static Client client = null;

    final static String URI = "https://fiapappbeercassandra.herokuapp.com/beers/";

    public static List<Beer> findAll(){
        Beer[] beers = null;
        int responseCode = 0;
        client = Client.create();
        try{
            webResource = client.
                    resource(URI + "findAll");
            response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                    .get(ClientResponse.class);
            beers =  new Gson().fromJson(response.getEntity(String.class), Beer[].class);
            responseCode = response.getStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(responseCode == 200){
            //close();
            return Arrays.asList(beers);
        }else {
            //close();
            return null;
        }
    }

    public static String updateBeer(Beer beer){
        Gson gson = new Gson();
        String json = gson.toJson(beer).toString();
        client = Client.create();
        try{
            webResource = client.
                    resource(URI + "update");
            response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).header("Content-type","application/json")
                    .post(ClientResponse.class, json);
            Log.e("Login", String.valueOf(response.getStatus()));
        } catch (Exception e) {
            //close();
            e.printStackTrace();
        }
        return null;
    }

    public static String deleteBeer(Beer beer){
        Gson gson = new Gson();
        String json = gson.toJson(beer).toString();
        client = Client.create();
        try{
            webResource = client.
                    resource(URI + "delete");
            response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).header("Content-type","application/json")
                    .delete(ClientResponse.class, json);
            Log.e("Login", String.valueOf(response.getStatus()));
        } catch (Exception e) {
            //close();
            e.printStackTrace();
        }
        return null;
    }

    public static String insertBeer(Beer beer){
        Gson gson = new Gson();
        String json = gson.toJson(beer).toString();
        client = Client.create();
        try{
            webResource = client.
                    resource(URI + "insert");
            response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).header("Content-type","application/json")
                    .post(ClientResponse.class, json);
            Log.e("Login", String.valueOf(response.getStatus()));
        } catch (Exception e) {
            //close();
            e.printStackTrace();
        }
        return null;
    }



}
