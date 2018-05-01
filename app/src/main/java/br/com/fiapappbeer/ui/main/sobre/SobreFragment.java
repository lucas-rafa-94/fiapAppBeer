package br.com.fiapappbeer.ui.main.sobre;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.ui.login.LoginActivity;
import br.com.fiapappbeer.ui.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {

    SharedPreferences s;
    SharedPreferences.Editor editor;

    Button btnLogout;

    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sobre, container, false);
        s = getContext().getSharedPreferences("loginController", 0);

        btnLogout = view.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               logout();
            }
        });

        return view;
    }

    public void logout(){
        if(s.getString("token", null) != null){
            if(s.getString("token", null).equals("teste:teste")){
                editor = s.edit();
                editor.putString("token", "");
                editor.commit();
                toLogin();
            }
        }else{
            toLogin();
        }
    }

    public void toLogin(){
        Intent toMain= new Intent(getContext(), LoginActivity.class);
        startActivity(toMain);
    }

}
