package br.com.fiapappbeer.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.api.controller.CriaUserController;
import br.com.fiapappbeer.api.models.User;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtIdade, edtPassword;
    CriaUserController criaUserController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtIdade = findViewById(R.id.edtIdade);
        edtPassword = findViewById(R.id.edtPassword);

    }

    public void criaUsuario(View v){
        criaUserController = new CriaUserController();
        User user = new User(Integer.parseInt(edtIdade.getText().toString()),
                                edtEmail.getText().toString(),
                                edtNome.getText().toString(),
                                edtPassword.getText().toString());
        criaUserController.execute(user);
    }
}
