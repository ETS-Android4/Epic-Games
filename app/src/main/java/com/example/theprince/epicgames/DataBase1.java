package com.example.theprince.epicgames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBase1 extends SQLiteOpenHelper{
    Cursor myCursor ;
    private final static String Key_nameGame = "nameMovie";
    private final static String Key_Uri = "textUri";
    private final static String Key_image1 = "img1";
    private final static String Key_image2 = "img2";
    private final static String Key_image3 = "img3";
    private final static String Key_descrip1 = "description1";
    private final static String Key_descrip2 = "description2";
    private final static String Key_descrip3 = "description3";
    /////////////////////////////////////////////
    private final static String DataBase_Name = "DataBase";
    private final static String DataBase_Table1 = "Games";
    private final static int DataBase_Version = 1;


    public DataBase1(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Games (nameMovie text not null ,textUri text not null ,img1 int not null " +
                ",img2 int not null ,img3 int not null ,description1 text not null ,description2 text not null ,description3 text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Games");
        onCreate(sqLiteDatabase);

    }

    ///////////////////Insert Data//////////////////
    public long insertData_Games(String game ,String uri ,int img1 ,int img2 ,int img3 ,String desc1 ,String desc2 ,String desc3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_nameGame,game);
        values.put(Key_Uri,uri);
        values.put(Key_image1,img1);
        values.put(Key_image2,img2);
        values.put(Key_image3,img3);
        values.put(Key_descrip1,desc1);
        values.put(Key_descrip2,desc2);
        values.put(Key_descrip3,desc3);
        return db.insert(DataBase_Table1,null,values);
    }

    ///////////////////////Retrieve Specified Row/////////////////////////
    public Cursor getSpecifiedRow_Games(String gamename){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor myCursor =db.rawQuery("select * from "+DataBase_Table1 +" where nameMovie = ?" ,new String[]{gamename},null);

        return myCursor ;
    }

}

