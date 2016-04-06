package com.cehsonu.speechrecognition1;

/**
 * Created by cehsonu on 3/30/2016.
 */
public class VoiceInputStringAnalyzerJava {
    String[] inp={"turn on wifi","turn off wifi"};
    public String voiceInputStringAnalyzer(String input)
    {
        int flag=0,i=0;
        input=input.toLowerCase();
        input=input.replaceAll("[^\\w_]","");       //replace all apart  [a-zA-Z0-9]
        for(i=0;i<2;i++)
        {
            if(input.equals(inp[i]))
            {
                flag = 2;
                break;
            }
        }
        if(flag==2)
            return this.inp[i];
        else
            return "not found";
    }
}
