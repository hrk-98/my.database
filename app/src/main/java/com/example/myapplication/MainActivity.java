package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    Database database;
    Button insert,upgrad,delete,retrive;
    EditText ids,name,surname,std;
    RecyclerView list;
    TextView t1,t2,t3;
    StudentAdapter adapter;

    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ids=findViewById(R.id.id1);
        name=findViewById(R.id.name1);
        surname=findViewById(R.id.surname1);
        std=findViewById(R.id.std1);

        list=findViewById(R.id.list);
        database=new Database(MainActivity.this);
        insert=findViewById(R.id.insert);
        retrive=findViewById(R.id.retrive);
        upgrad=findViewById(R.id.upgrad);
        delete=findViewById(R.id.delete);

        t1=findViewById(R.id.name);
        t2=findViewById(R.id.surname);
        t3=findViewById(R.id.std);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n1 =name.getText().toString();
                String n2 =surname.getText().toString();
                String n3 =std.getText().toString();

                database.Insertdata(n1,n2,n3);

            }
        });

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<StudentData> datalist = database.RetriveData();
                adapter = new StudentAdapter(MainActivity.this,datalist);
                list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                list.setAdapter(adapter);


            }
        });

        upgrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=Integer.parseInt(ids.getText().toString());
                String n1 =name.getText().toString();
                String n2 =surname.getText().toString();
                String n3 =std.getText().toString();
                database.UpdateData(id,n1,n2,n3);


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =Integer.parseInt(ids.getText().toString());
                database.DeleteData(id);
            }
        });


    }
}