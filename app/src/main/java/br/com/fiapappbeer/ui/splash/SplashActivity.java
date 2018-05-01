package br.com.fiapappbeer.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.ui.login.LoginActivity;


public class SplashActivity extends AppCompatActivity {
    ImageView ivSplash;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        setAnim();
    }

    public void setAnim (){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_splash);
        ivSplash.startAnimation(anim);

        final Intent intent = new Intent(this, LoginActivity.class);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(intent);
            }
        }, 4000);

    }
}
