package com.cehsonu.speechrecognition1;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say something");
        startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    TextView speechInput = (TextView) findViewById(R.id.show_input);
                    int listSize=result.size();
                    Log.i("size ",Integer.toString(listSize));
                    for(int i=0;i<listSize;i++)
                        Log.i("members ",result.get(i));
                    speechInput.setText(result.get(0));

                    /*make obj of VoiceInputStringAnalyzerJava and call function to manipulate given voice input string*/
                    VoiceInputStringAnalyzerJava voiceInputStringAnalyzerJava=new VoiceInputStringAnalyzerJava();
                    //String id=voiceInputStringAnalyzerJava.voiceInputStringAnalyzer(result.get(0));
                    //int test=WifiToggleService.class;


                  /*  if (result.get(0).equals("turn on WiFi") || result.get(0).equals("turn off WiFi")) {
                        Intent wifi_intent = new Intent(this, WifiToggleService.class);
                        wifi_intent.putExtra(WifiToggleService.EXTRA_MESSAGE, result.get(0));
                        startService(wifi_intent);
                    }
                    else
                    {
                        ContentResolver cr = getContentResolver();
                        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                        if (cursor.getCount() > 0) {
                            while (cursor.moveToNext()) {
                                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                                String call = "call ";
                                String searchName = call.concat(name);
                                if (result.get(0).equals(searchName)) {

                                    if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                                        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                                        while (pCur.moveToNext()) {
                                            String phone = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                            Intent call_intent = new Intent(Intent.ACTION_CALL);
                                            String tel = "tel:";

                                            String callNumber = tel.concat(phone);
                                            speechInput.setText(callNumber);
                                            SayOnSuccessOrFailure tts = new SayOnSuccessOrFailure();
                                            tts.init(this);
                                            call_intent.setData(Uri.parse(callNumber));
                                            startActivity(call_intent);
                                            break;
                                        }

                                    }
                                }
                            }
                        }

                    }*/



                }
            }
        }
    }
}