package roshni.com.dbtrial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roshni on 4/9/2016.
 */
public class DBhelper extends SQLiteOpenHelper{

    //Table name
    public static final String TABLE_NAME="Twitch";

    //column name
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String LOCATION= "location";

    //DB Info
    static final String DB_NAME = "TwitchDB1.db";
    static final int DB_VERSION = 1;


    public DBhelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + " (_ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT NOT NULL,LOCATION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists "+TABLE_NAME);
        onCreate(db);
    }
}
