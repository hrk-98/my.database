package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class dilouge extends AppCompatActivity {

   public static Database database;
    Button insert,upgrad,delete;
    EditText ids,name,surname,std;
   public static RecyclerView list1;
    Button update,b2;
    TextView t1,t2,t3;
   public static StudentAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilouge);


        ids=findViewById(R.id.id1);
        name=findViewById(R.id.name1);
        surname=findViewById(R.id.surname1);
        std=findViewById(R.id.std1);

        list1=findViewById(R.id.list1);
        database=new Database(dilouge.this);
        insert=findViewById(R.id.insert);
        upgrad=findViewById(R.id.upgrad);
        delete=findViewById(R.id.delete);

        t1=findViewById(R.id.name);
        t2=findViewById(R.id.surname);
        t3=findViewById(R.id.std);

        update=findViewById(R.id.update);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n1 =name.getText().toString();
                String n2 =surname.getText().toString();
                String n3 =std.getText().toString();
                database.Insertdata(n1,n2,n3);

                List<StudentData> datalist = database.RetriveData();
                adapter = new StudentAdapter2(dilouge.this,datalist);
                list1.setLayoutManager(new LinearLayoutManager(dilouge.this));
                list1.setAdapter(adapter);


            }
        });

    }

    public static void refresh(Activity activity){

        List<StudentData> datalist = database.RetriveData();
        adapter = new StudentAdapter2(activity,datalist);
        list1.setLayoutManager(new LinearLayoutManager(activity));
        list1.setAdapter(adapter);

    }
}