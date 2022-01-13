package com.example.theprince.epicgames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
    private final static String Key_fName = "fname";
    private final static String Key_lName = "lname";
    private final static String Key_userName = "username";
    private final static String Key_password = "password";
    private final static String Key_address = "address";
    private final static String Key_phone = "phone";
    private final static String Key_active = "active";
    private final static String Key_editInfo = "editInfo";
    ////////////////////////////////////////////
    private final static String Key_id = "id_user";
    private final static String Key_date = "date";
    private final static String Key_time = "time";
    private final static String Key_image = "image";
    private final static String Key_gamename = "gamename";
    private final static String Key_price = "price";
    ////////////////////////////////////////////
    private final static String DataBase_Name = "DataBase";
    private final static String DataBase_Table2 = "Users";
    private final static String DataBase_Table3 = "Info_Users";
    private final static int DataBase_Version = 1;

    public DataBase(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Users (fname text not null ,lname text not null ,username text not null " +
                ",password text not null ,address text not null ,phone text not null ,active text not null ,editInfo text not null ,id integer primary key autoincrement)");

        sqLiteDatabase.execSQL("create table Info_Users (id_user int not null ,date text not null ,time text not null " +
                ",image int not null,gamename text not null ,price text not null )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Info_Users");
        onCreate(sqLiteDatabase);
    }

    ///////////////////Insert Data//////////////////
    public long insertData_users(String fname , String lname ,String username,String password ,String address ,String phone ,String active ,String editInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_fName,fname);
        values.put(Key_lName,lname);
        values.put(Key_userName,username);
        values.put(Key_password,password);
        values.put(Key_address,address);
        values.put(Key_phone,phone);
        values.put(Key_active,active);
        values.put(Key_editInfo,editInfo);
        return db.insert(DataBase_Table2,null,values);
    }

    public long insertData_usersInfo(int id , String date ,String time ,int image,String gamename ,String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_id,id);
        values.put(Key_date,date);
        values.put(Key_time,time);
        values.put(Key_image,image);
        values.put(Key_gamename,gamename);
        values.put(Key_price,price);
        return db.insert(DataBase_Table3,null,values);
    }


    ////////////////Update Row/////////////////////////
    public boolean updateRow_users(String fname , String lname ,String username,String password ,String address ,String phone ,String active){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_fName,fname);
        values.put(Key_lName,lname);
        values.put(Key_userName,username);
        values.put(Key_password,password);
        values.put(Key_address,address);
        values.put(Key_phone,phone);
        db.update(DataBase_Table2 ,values , " active = ?",new String[]{active});
        return true;
    }

    public boolean update_active(String username,String password ,String active){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_active,active);
        db.update(DataBase_Table2 ,values ," username =? and password = ? " ,new String[]{username,password});
        return true;
    }

    public boolean update_editInfo(String username,String password ,String editInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_editInfo,editInfo);
        db.update(DataBase_Table2 ,values ," username =? and password = ? " ,new String[]{username,password});
        return true;
    }

    ///////////////////////Retrieve Specified Row/////////////////////////
    public Cursor getSpecifiedRow_users(String active){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor myCursor =db.rawQuery("select * from "+DataBase_Table2 +" where active = ?" ,new String[]{active},null);

        return myCursor ;
    }

    public Cursor getSpecifiedRow_users2(String editInfo){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor myCursor =db.rawQuery("select * from "+DataBase_Table2 +" where editInfo = ?" ,new String[]{editInfo},null);

        return myCursor ;
    }

    public Cursor checkPassword(String username ,String password){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor myCursor =db.rawQuery("select * from "+DataBase_Table2 +" where username =? and password =? " ,new String[]{username,password},null);

        return myCursor;
    }

    public Cursor getSpecifiedRow_usersInfo(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor myCursor =db.rawQuery("select * from "+DataBase_Table3 +" where id_user = " + id,null);

        return myCursor ;
    }

}

