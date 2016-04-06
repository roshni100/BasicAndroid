package com.roshni.com.prakash;

/**
 * Created by Roshni on 3/20/2016.
 */
public class Reminder {
    private String name;
    private String description;
    private int imageResourceId;
    public static final Reminder[] reminders = {new Reminder("Meeting","To give the reminder of important meeting",R.drawable.meeting),
            new Reminder("Birthday","To wish some  important member birthday remind",R.drawable.birthday),
            new Reminder("Anniversary","To wish some  important member anniversary remind",R.drawable.anniversary)};

    private Reminder(String name, String description, int imageResourceId)
        {
            this.name=name;
            this.description=description;
            this.imageResourceId=imageResourceId;
        }
    public String getDescription()
    {
        return description;

    }
    public String getName()
    {
        return name;

    }
    public int getImageResourceId()
    {
        return  imageResourceId;

    }
    public String toString()
    {
        return this.name;
    }


}
