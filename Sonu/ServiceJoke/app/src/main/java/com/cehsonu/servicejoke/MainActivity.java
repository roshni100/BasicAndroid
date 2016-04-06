package com.cehsonu.servicejoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showText(View view){
        Intent intent=new Intent(this,DelayedMessageService.class);
        intent.putExtra(DelayedMessageService.EXTRA_MESSAGE,getResources().getString(R.string.button_response));
        startService(intent);
    }


}
