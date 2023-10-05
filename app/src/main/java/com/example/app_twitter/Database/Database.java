package com.example.app_twitter.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    final public static Integer VERSION = 0;
    final public static String TABLE_Post= "Table_post";
    final public static String Database = "Database_post";
    final public static String COLUMN_Id_post = "id_post";
    final public static String COLUMN_Name = "name_post";
    final public static String COLUMN_Username = "username_Post";
    final public static String COLUMN_Textbody = "textbody_Post";
    final public static String COLUMN_Time = "time_post";
    final public static String COLUMN_Like = "like_Post";
    final public static String COLUMN_image = "like_image";
    ///
    final public static String Table_New_User_Name = "new_users";
    final public static String COLUMN_New_Id = "new_id";
    final public static String COLUMN_New_Name = "new_name";
    final public static String COLUMN_New_Username = "new_username";
    final public static String COLUMN_New_Email = "new_email";
    final public static String COLUMN_New_Password = "new_password";

    public Database(@Nullable Context context) {
        super(context, Database,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String TablePost =  "create table " + TABLE_Post + "(" +
              COLUMN_Id_post + " integer primary key autoincrement, " +
              COLUMN_Name + " text not null, " +
              COLUMN_Username + " text not null, " +
              COLUMN_Textbody + " text not null, " +
              COLUMN_Time + " text not null, " +
              COLUMN_Like + " integer, " +
              COLUMN_image + " blob" +
              ")";
      String TableUsers ="create table " + Table_New_User_Name + "(" +
              COLUMN_New_Id + " integer primary key autoincrement, " +
              COLUMN_New_Name + " text not null, " +
              COLUMN_New_Username + " text not null, " +
              COLUMN_New_Email + " text not null, " +
              COLUMN_New_Password + " text not null" +
              ")";
      sqLiteDatabase.execSQL(TablePost);
        sqLiteDatabase.execSQL(TableUsers);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" drop table  if exists " + TABLE_Post);
        sqLiteDatabase.execSQL(" drop table  if exists " + Table_New_User_Name);
        onCreate(sqLiteDatabase);
    }

//    public boolean insertUser(user user) {
//        SQLiteDatabase liteDatabase = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        values.put(COLUMN_name, user.getName());
//        values.put(COLUMN_Email, user.getEmail());
//        values.put(COLUMN_Password, user.getPassword());
//        values.put(COLUMN_name, user.getName());
//
//        long Result = liteDatabase.insert(Table_User_Name, null, values);
//        return Result != -1;
//    }
}
