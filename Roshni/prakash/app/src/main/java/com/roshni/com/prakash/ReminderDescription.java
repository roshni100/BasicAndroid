package com.roshni.com.prakash;

/**
 * Created by Roshni on 3/20/2016.
 */
;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class ReminderDescription extends Activity {
    public static final String EXTRA_REMINDERNO = "reminderNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_reminder);
//Get the reminder from the intent
        int reminderNo = (Integer) getIntent().getExtras().get(EXTRA_REMINDERNO);
        Reminder reminders = Reminder.reminders[reminderNo];
//Populate the reminder image
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(reminders.getImageResourceId());
        photo.setContentDescription(reminders.getName());
//Populate the reminder name
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(reminders.getName());
//Populate the remindder description
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(reminders.getDescription());
    }
}

