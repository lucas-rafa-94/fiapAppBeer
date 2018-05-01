package br.com.fiapappbeer.ui.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.ui.main.insertBeer.CadastroBeerFragment;
import br.com.fiapappbeer.ui.main.listBeer.ListBeerFragment;
import br.com.fiapappbeer.ui.main.sobre.SobreFragment;

public class MainActivity extends AppCompatActivity {


    private ListBeerFragment listBeerFragment;
    private CadastroBeerFragment cadastroBeerFragment;
    private SobreFragment sobreFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    sobreFragment = new SobreFragment();
                    changeFragment(sobreFragment);
                    return true;
                case R.id.navigation_dashboard:
                    listBeerFragment = new ListBeerFragment();
                    changeFragment(listBeerFragment);
                    return true;
                case R.id.navigation_notifications:
                    cadastroBeerFragment = new CadastroBeerFragment();
                    changeFragment(cadastroBeerFragment);
                    return true;
            }
            return false;
        }
    };

    private void changeFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerFragment, fragment);
        transaction.commit();
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        sobreFragment = new SobreFragment();
        changeFragment(sobreFragment);
    }

}
