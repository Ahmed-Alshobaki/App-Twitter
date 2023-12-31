package com.example.app_twitter.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.app_twitter.adapter.post_itam;
import com.example.app_twitter.users.user;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Database1 extends SQLiteOpenHelper {

    final public static Integer VERSION = 4;
    final public static String TABLE_Post= "Table_post";
    final public static String Database = "Database_post";
    final public static String COLUMN_Id_post = "id_post";
    final public static String COLUMN_Name = "name_post";
    final public static String COLUMN_Username = "username_Post";
    final public static String COLUMN_Textbody = "textbody_Post";
    final public static String COLUMN_Time = "time_post";
    final public static String COLUMN_Like = "like_Post";
    final public static String COLUMN_image = "image";
    ///
    final public static String Table_New_User_Name = "new_users";
    final public static String COLUMN_New_Id = "new_id";
    final public static String COLUMN_New_Name = "new_name";
    final public static String COLUMN_New_Username = "new_username";
    final public static String COLUMN_New_Email = "new_email";
    final public static String COLUMN_New_Password = "new_password";

    public Database1(@Nullable Context context) {
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
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = currentDateTime.format(formatter);
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" drop table  if exists " + TABLE_Post);
        sqLiteDatabase.execSQL(" drop table  if exists " + Table_New_User_Name);
        onCreate(sqLiteDatabase);
    }

    public  boolean insertUser(user user) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_New_Name, user.getName());
        values.put(COLUMN_New_Username, user.getUsername());
        values.put(COLUMN_New_Email, user.getEmail());
        values.put(COLUMN_New_Password, user.getPassword());

        long Result = liteDatabase.insert(Table_New_User_Name, null, values);
        return Result != -1;
    }
    public  boolean insertPost(post_itam post_itam) {
        SQLiteDatabase liteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_Name, post_itam.getName());
        values.put(COLUMN_Username, post_itam.getUsername());
        values.put(COLUMN_Like, post_itam.getLike());
        values.put(COLUMN_Time, post_itam.getTime());
        values.put(COLUMN_Textbody, post_itam.getTextbody());
        long Result = liteDatabase.insert(TABLE_Post, null, values);
        return Result != -1;
    }
    public Cursor getCursor() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + Table_New_User_Name, null);
        return cursor;

    }



    public boolean isExists(String name,String COLUMN) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;
        boolean usernameExists = false;

        try {
            String query = "SELECT COUNT(*) FROM " + Table_New_User_Name + " WHERE " + COLUMN + " = ?";
            cursor = db.rawQuery(query, new String[]{name});

            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        if (count>0){
            return  false;
        }{return  true;}
    }
    @SuppressLint("Range")
    public user getUserByUsername(String Name  , String COLUMN) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        user user = null;

        try {
            String query = "SELECT * FROM " + Table_New_User_Name + " WHERE " + COLUMN + " = ?";
            cursor = db.rawQuery(query, new String[]{Name});

            if (cursor != null && cursor.moveToFirst()) {
                // استخراج البيانات من الاستعلام
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_New_Name));
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_New_Email));
               String password = cursor.getString(cursor.getColumnIndex(COLUMN_New_Password));
               String Username = cursor.getString(cursor.getColumnIndex(COLUMN_New_Username));
                // إنشاء كائن User باستخدام البيانات
                user = new user(name,Username,email,password);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return user;
    }
    @SuppressLint("Range")
    public ArrayList<post_itam> getPostList() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery("SELECT * FROM " + TABLE_Post + " ORDER BY time_post DESC", null);
        ArrayList<post_itam> list = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();


        while (cursor.moveToNext()) {
            String otherTime  =cursor.getString(cursor.getColumnIndex(COLUMN_Time));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(otherTime, formatter);
            Duration duration = Duration.between(dateTime, currentTime);
            long totaltime = duration.toMinutes();
            String totaltimeString=String.valueOf("-"+totaltime+"m");
            if (totaltime>=60){
                totaltime = duration.toHours();
                totaltimeString = String.valueOf("-"+totaltime+"h");
                if (totaltime>=24){
                    totaltime = duration.toDays();
                    totaltimeString = String.valueOf("-"+totaltime+"d");
                }
            }
            System.out.println(totaltime+"dd");
            post_itam post_itam = new post_itam();
            post_itam.setName(cursor.getString(cursor.getColumnIndex(COLUMN_Name)));
            post_itam.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_Username)));
            post_itam.setTextbody(cursor.getString(cursor.getColumnIndex(COLUMN_Textbody)));
            post_itam.setLike(cursor.getInt(cursor.getColumnIndex(COLUMN_Like)));
            post_itam.setTime(totaltimeString);

          list.add(post_itam);
        }
        return list;

    }



}
