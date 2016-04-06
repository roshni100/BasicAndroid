package com.cehsonu.speechrecognition1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by cehsonu on 3/12/2016.
 */
public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread=new Thread()
        {
            public void run()
            {
                try {
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}
