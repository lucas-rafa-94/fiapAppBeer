package br.com.fiapappbeer.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.ui.main.MainActivity;
import br.com.fiapappbeer.api.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences s;
    SharedPreferences.Editor editor;

    EditText edtLogin, edtSenha;
    public CheckBox manterLogado;
    Button btnLogar;
    TextView txtCadastro;

    LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        s = getApplicationContext().getSharedPreferences("loginController", 0);
        init();

        manterLogado = findViewById(R.id.checkBoxLogado);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogar = findViewById(R.id.btnLogar);
        txtCadastro = findViewById(R.id.txtcadastro);

        String str_cadastro = getString(R.string.cadastro);

        txtCadastro.setText(Html.fromHtml(str_cadastro));

    }

    public void init(){
        if(s.getString("token", null) != null){
            if(s.getString("token", null).equals("teste:teste")){
                Intent toMain= new Intent(this, MainActivity.class);
                startActivity(toMain);
            }
        }
    }

    public void gravarSharedPreferences(){
        editor = s.edit();
        editor.putString("token", "teste:teste");
        editor.commit();
    }

    public void logar (View v){
        loginController = new LoginController(this);
        loginController.execute(edtLogin.getText().toString(),edtSenha.getText().toString());
    }

    public void toMain(){
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    public void toCadastro(View v){
        Intent toCadastro = new Intent(this, CadastroActivity.class);
        startActivity(toCadastro);
    }
}
