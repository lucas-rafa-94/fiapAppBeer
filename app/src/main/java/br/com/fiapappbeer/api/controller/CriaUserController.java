package br.com.fiapappbeer.api.controller;

import android.os.AsyncTask;

import br.com.fiapappbeer.api.models.User;
import br.com.fiapappbeer.api.services.UserServices;

/**
 * Created by lucasdossantos on 4/29/18.
 */

public class CriaUserController extends AsyncTask<User,String,String> {
    @Override
    protected String doInBackground(User... users) {
        UserServices.criaUsuario(users[0]);
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
