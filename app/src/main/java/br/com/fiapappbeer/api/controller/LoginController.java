package br.com.fiapappbeer.api.controller;


import android.os.AsyncTask;
import br.com.fiapappbeer.ui.login.LoginActivity;
import br.com.fiapappbeer.api.services.UserServices;

/**
 * Created by lucasdossantos on 4/29/18.
 */

public class LoginController extends AsyncTask<String, String, String>{

    private LoginActivity loginActivity;
   public LoginController(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
       String resultado = String.valueOf(UserServices.validaLogin(strings[0], strings[1]));
       return resultado;
    }

    @Override
    protected void onPostExecute(String resultado) {
        if(resultado.equals("200") && loginActivity.manterLogado.isChecked()){
            loginActivity.gravarSharedPreferences();
            loginActivity.toMain();
        }else if (resultado.equals("200") && !loginActivity.manterLogado.isChecked()){
            loginActivity.toMain();
        }
    }
}
