package com.roshni.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class GetMessageActivity extends AppCompatActivity {

    public  String messageBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_message);
        Intent intent=getIntent();
        String message=intent.getStringExtra(messageBody);
        TextView messageView=(TextView)findViewById(R.id.messageView);
        messageView.setText(message);
    }

}
