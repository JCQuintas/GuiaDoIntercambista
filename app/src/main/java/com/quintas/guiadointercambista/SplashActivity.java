package com.quintas.guiadointercambista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    ImageView outside;
    ImageView inside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        outside = (ImageView) findViewById(R.id.outside);
//        inside = (ImageView) findViewById(R.id.inside);
//
//        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.linear_rotation_clockwise);
//        rotation.setRepeatCount(Animation.INFINITE);
//        outside.startAnimation(rotation);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(2000); //Delay of 3 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(SplashActivity.this,
//                            MainActivity.class);
                            SignupActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
