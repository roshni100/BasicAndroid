package com.sonu.speechrecognitiontwitch;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecognitionListener{

    //Declaring all objects for clear understanding
    private TextView voiceInputTextView;
    private ToggleButton startStopButton;
    private ProgressBar progressBar;
    private SpeechRecognizer speechRecognizer = null;
    private Intent recognizerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiceInputTextView = (TextView) findViewById(R.id.voiceinputTextView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        startStopButton = (ToggleButton) findViewById(R.id.toggleButton);

        progressBar.setVisibility(View.INVISIBLE);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "hin");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);

        startStopButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    speechRecognizer.startListening(recognizerIntent);
                    //progressBar.setVisibility(View.VISIBLE);
                    //progressBar.setIndeterminate(true);
                    //speechRecognizer.startListening(recognizerIntent);
                } else {
                    speechRecognizer.stopListening();
                    //progressBar.setIndeterminate(false);
                    //progressBar.setVisibility(View.INVISIBLE);
                    //speechRecognizer.stopListening();
                }
            }
        });
    }

    //@Override
    public void onResume() {
        super.onResume();
    }

    //@Override
    protected void onPause() {
        super.onPause();
        if(speechRecognizer != null) {
            speechRecognizer.destroy();
        }
    }

    @Override
    public void onBeginningOfSpeech () {
         Log.i("LOG_TAG","onBeginningSpeech");
         progressBar.setIndeterminate(false);
         progressBar.setMax(10);
    }

    @Override
    public void onBufferReceived(byte[] buffer) {
         Log.i("LOG_TAG", "onBufferReceived" + buffer);
    }

    @Override
    public void onEndOfSpeech() {
         Log.i("LOG_TAG","onendofspeech");
         progressBar.setIndeterminate(true);
         startStopButton.setChecked(false);
    }

    @Override
    public void onError(int errorCode) {
        String errorMsg = getErrorMsg(errorCode);
        Log.d("Log_Error", errorMsg);
        voiceInputTextView.setText(errorMsg);
        startStopButton.setChecked(false);
    }

    @Override
    public void onEvent(int arg0, Bundle arg1) {
        Log.i("LOG_EVENT", "onEvent");
    }

    @Override
    public void onPartialResults(Bundle arg0) {
        Log.i("LOG_TAG", "onPartialResult");
    }

    @Override
    public void onReadyForSpeech(Bundle arg0) {
        Log.i("LOG_TAG", "onReadyForSpeech");
    }

    @Override
    public void onResults(Bundle results) {
        Log.i("Log_TAG", "onResults");
        ArrayList<String> result = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        //String text =
        voiceInputTextView.setText(result.get(0));
    }

    @Override
    public void onRmsChanged(float rmsdB) {
        Log.i("LOG_TAG", "onRmsChanged: " + rmsdB);
        //progressBar.setProgress((int) rmsdB);
    }

    public static String getErrorMsg(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
