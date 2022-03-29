package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainpage extends AppCompatActivity {

    Button all,no_retrive,dilouge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        all=findViewById(R.id.all);
        no_retrive=findViewById(R.id.no_retrive);
        dilouge=findViewById(R.id.dilouge);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainpage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        no_retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainpage.this,no_retrive.class);
                startActivity(intent);
            }
        });

        dilouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainpage.this,dilouge.class);
                startActivity(intent);
            }
        });



    }
}