package br.com.fiapappbeer.api.controller;

import android.os.AsyncTask;

import br.com.fiapappbeer.api.models.Beer;
import br.com.fiapappbeer.api.services.BeerServices;

/**
 * Created by lucasdossantos on 5/1/18.
 */

public class UpdateBeerController extends AsyncTask<Beer,String,String> {

    @Override
    protected String doInBackground(Beer... beers) {
        BeerServices.updateBeer(beers[0]);
        return null;
    }
}
