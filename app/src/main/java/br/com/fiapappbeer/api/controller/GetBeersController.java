package br.com.fiapappbeer.api.controller;

import android.os.AsyncTask;

import java.util.List;

import br.com.fiapappbeer.ui.main.listBeer.ListBeerFragment;
import br.com.fiapappbeer.api.models.Beer;
import br.com.fiapappbeer.api.services.BeerServices;

/**
 * Created by lucasdossantos on 5/1/18.
 */

public class GetBeersController extends AsyncTask<List<Beer>,String,List<Beer>> {
    private ListBeerFragment listBeerFragment;

    public GetBeersController(ListBeerFragment listBeerFragment) {
        this.listBeerFragment = listBeerFragment;
    }

    @Override
    protected List<Beer> doInBackground(List<Beer>[] lists) {
        List<Beer> list = BeerServices.findAll();
        if(list != null){
            return list;
        }else {
            return null;
        }

    }

}
