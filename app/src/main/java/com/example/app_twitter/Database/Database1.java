package com.example.app_twitter.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.app_twitter.users.user;

public class Database1 extends SQLiteOpenHelper {

    final public static Integer VERSION = 1;
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
    public Cursor getCursor() {
        SQLiteDatabase liteDatabase = this.getReadableDatabase();
        Cursor cursor = liteDatabase.rawQuery(" select * from " + Table_New_User_Name, null);
        return cursor;

    }
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        boolean emailExists = false;

        try {
            String query = "SELECT " + Table_New_User_Name + " FROM " + COLUMN_New_Email + " WHERE " + email + " = ?";
            cursor = db.rawQuery(query, new String[]{email});

            if (cursor != null && cursor.getCount() > 0) {
                emailExists = true;
            }
        } catch ( Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return emailExists;
    }
    public boolean isUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        boolean usernameExists = false;

        try {
            String query = "SELECT " + Table_New_User_Name + " FROM " + COLUMN_New_Username + " WHERE " + username + " = ?";
            cursor = db.rawQuery(query, new String[]{username});

            if (cursor != null && cursor.getCount() > 0) {
                // اسم المستخدم موجود في الجدول
                usernameExists = true;
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return usernameExists;
    }



}