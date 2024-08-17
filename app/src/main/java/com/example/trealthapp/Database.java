package com.example.trealthapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry1= "create table orderpackage(packageName text,price float)";
        db.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void register(String username,String mail,String pass){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",mail);
        cv.put("password",pass);
        SQLiteDatabase DB=getWritableDatabase();
        DB.insert("users",null,cv);
        DB.close();
    }

    public int login(String username,String password){
        int result=0;
        String[] str =new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase datab=getReadableDatabase();
        @SuppressLint("Recycle") Cursor c=datab.rawQuery("Select * from users where username=? and password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return result;
    }
    public void addCart(String username,String product,float price,String otype){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("otype",otype);
        SQLiteDatabase datab=getWritableDatabase();
        datab.insert("cart",null,cv);
        datab.close();
    }
    public int checkCart(String username,String product){
        int result=0;
        String[] str =new String[2];
        str[0]=username;
        str[1]=product;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from cart where username=? and product=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        db.close();
        return result;
    }
    public void removeCart(String username,String otype){
        String[] str =new String[2];
        str[0]=username;
        str[1]=otype;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();

    }
    public ArrayList getCartData(String username,String otype){
        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String[] str =new String[2];
        str[0]=username;
        str[1]=otype;
        Cursor c =db.rawQuery("select * from cart where username=? and otype=?",str);
        if(c.moveToFirst()){
            do{
                String product=c.getString(1);
                String price=c.getString(2);
                arr.add(product+"$"+price);

            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }
    public void addOrder(String packageName,float price){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("packageName",packageName);
        cv.put("price",price);
        db.insert("orderpackage",null,cv);
        db.close();

    }

}
