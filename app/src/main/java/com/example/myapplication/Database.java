package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    Context context;

    public Database(@Nullable Context context) {
        super(context, " Mydata.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String que = "CREATE TABLE student(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Surname TEXT,std TEXT)";
        db.execSQL(que);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Insertdata(String name, String surname, String std) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("surname", surname);
        values.put("std", std);

        long is = db.insert("student", null, values);

        if (is == -1) {

            Toast.makeText(context, "Data is not inserted", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(context, "Data is inserted", Toast.LENGTH_SHORT).show();
        }
    }

        public List<StudentData> RetriveData() {
            List<StudentData> dataList = new ArrayList<>();

            SQLiteDatabase db1 = getReadableDatabase();
            String que = "SELECT * FROM student";
            Cursor cursor = db1.rawQuery(que, null);
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                int id = cursor.getInt(0);
                String name1 = cursor.getString(1);
                String surname1 = cursor.getString(2);
                String std1 = cursor.getString(3);
                StudentData data = new StudentData(id, name1, surname1, std1);
                dataList.add(data);
                cursor.moveToNext();
            }
            return dataList;
        }

        public void UpdateData(int id,String name, String surname,String std){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id",id);
        values.put("name",name);
        values.put("surname",surname);
        values.put("std",std);

        long is =db.update("student",values,"id="+id,null);
        if (is == -1){

            Toast.makeText(context, "Data is not update", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(context, "Data is update", Toast.LENGTH_SHORT).show();
        }

        }

        public void DeleteData(int id){

        SQLiteDatabase db =getWritableDatabase();
        long is=db.delete("student","id ="+id,null);
        if (is==-1){

            Toast.makeText(context, "Data is not delete", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Data is delete;", Toast.LENGTH_SHORT).show();
        }

        }


}