package com.roshni.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public String messageBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view)  {
        EditText messageView=(EditText)findViewById(R.id.messageBox);
        String message=messageView.getText().toString();
        Intent intent = new Intent(this, GetMessageActivity.class);
        intent.putExtra(messageBody,message);
        startActivity(intent);
    }
}



