package com.roshni.com.prakash;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
public class ReminderActivity extends ListActivity {


   private static final String EXTRA_REMINDERNO="reminderNo" ;
    int reminderNo = (Integer)getIntent().getExtras().get(EXTRA_REMINDERNO);
   Reminder reminders = Reminder.reminders[reminderNo];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listReminds = getListView();
        ArrayAdapter<Reminder> listAdapter = new ArrayAdapter<Reminder>(this, android.R.layout.simple_list_item_1, Reminder.reminders);
        listReminds.setAdapter(listAdapter);
                                                       }
    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(ReminderActivity.this, ReminderDescription.class);
        intent.putExtra(ReminderActivity.EXTRA_REMINDERNO,(int) id);
        startActivity(intent);
    }

}
