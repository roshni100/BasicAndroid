package com.cehsonu.speechrecognition1;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

/**
 * Created by cehsonu on 3/21/2016.
 */
public class SayOnSuccessOrFailure implements TextToSpeech.OnInitListener {
    TextToSpeech tts;

    public void init(Context context){
        tts=new TextToSpeech(context, this);
        speakOut();
    }
    public void onInit(int status)
    {
        if(status==TextToSpeech.SUCCESS)
        {
            int result = tts.setLanguage(Locale.US);
            if(result == TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("TTS","Language not suported");
            }
            else{
                speakOut();
            }
        }
    }
    public void speakOut(){
        String text="Thus is call for you";
        tts.setLanguage(Locale.US);
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}
