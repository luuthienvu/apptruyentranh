package com.example.apptruyentranh.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databasedocTruyen extends SQLiteOpenHelper {


    private  static String DATABASE_NAME = "docTruyen";
    private  static String TABLE_TAIKHOAN ="taikhoan";
    private  static String ID_TAIKHOAN ="idtaikhoan";
    private  static String  TEN_TAIKHOAN="tentaikhoan";
    private  static String  MAT_KHAU="matkhau";
    private  static String  GMAIL="gmail";
    private  static int VERSION =1;


    private  static String  TABLE_TRUYEN="truyen";
    private  static String  ID_TRUYEN="idtruyen";
    private  static String  IMAGE="anh";
    private  static String  TEN_TRUYEN="tentruyen";
    private  static String TEN_CHAP="tenchap";



    private  Context context;


    private String SQLQuery ="CREATE TABLE " +TABLE_TAIKHOAN+"("+ID_TAIKHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT,"
        +TEN_TAIKHOAN+" TEXT UNIQUE,"
        +MAT_KHAU+" TEXT,"
        +GMAIL+" TEXT)";


    private String SQLQuery1 ="CREATE TABLE " +TABLE_TRUYEN+"("+ID_TRUYEN+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TEN_TRUYEN+" TEXT UNIQUE,"
            +TEN_CHAP+" TEXT,"
            +IMAGE+" TEXT,"+ID_TAIKHOAN+" INTEGER, FOREIGN KEY ("+ID_TAIKHOAN+") REFERENCES "+ TABLE_TAIKHOAN+"("+ID_TAIKHOAN+"))";



    private String SQLQuery2="INSERT INTO taikhoan VALUES(null,'thienvu','thienvu','vu@gmail.com',1)";








    public databasedocTruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVERSION, int newVERSION) {

    }
    public Cursor getData(){
        SQLiteDatabase db= this.getReadableDatabase();
        return db.rawQuery("SELECT *FROM "+TABLE_TAIKHOAN,null);
    }
}
