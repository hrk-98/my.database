package com.example.myapplication;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter2 extends RecyclerView.Adapter<StudentAdapter2.StudentHolder> {

    Activity activity;
    public static List<StudentData> dataList;
    Database database;
    EditText i1;
    StudentAdapter2 adapter;
    RecyclerView list1;
    public StudentAdapter2(Activity activity , List<StudentData> dataList){
        this.activity=activity;
        this.dataList=dataList;

    }
    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.list_item2,parent,false);
        return new StudentHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.id.setText("ID : "+dataList.get(position).id+"");
        holder.name.setText("NAME : "+dataList.get(position).name);
        holder.surname.setText("SURNAME : "+dataList.get(position).surname);
        holder.std.setText("STD : "+dataList.get(position).std);


        holder.b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                Dialog dialog=new Dialog(activity);
                dialog.setContentView(R.layout.dilouge1);
                dialog.setCancelable(true);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
                Button button =dialog.findViewById(R.id.update);

                EditText i1=dialog.findViewById(R.id.id1);
                EditText e1=dialog.findViewById(R.id.name1);
                EditText s1=dialog.findViewById(R.id.surname1);
                EditText st1=dialog.findViewById(R.id.std1);

                i1.setText(dataList.get(position).id+"");
                e1.setText(dataList.get(position).name);
                s1.setText(dataList.get(position).surname);
                st1.setText(dataList.get(position).std);


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<StudentData> dataList = new ArrayList<>();


                        database =new Database(activity);
                        dialog.dismiss();

                        int id= Integer.parseInt(i1.getText().toString());
                        String n1 =e1.getText().toString();
                        String n2 =s1.getText().toString();
                        String n3 =st1.getText().toString();
                        database.UpdateData(id,n1,n2,n3);


                        dilouge.refresh(activity);

                    }
                });

                dialog.show();
            }
        });



        holder.b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(activity);
                dialog.setContentView(R.layout.delete);
                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));

                Button button1 =dialog.findViewById(R.id.delete1);
                EditText i11=dialog.findViewById(R.id.id);
                i11.setText(dataList.get(position).id+"");
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        database =new Database(activity);
                        int id =Integer.parseInt(i11.getText().toString());
                        database.DeleteData(id);
                        dilouge.refresh(activity);
                        dialog.dismiss();

                    }
                });

                dialog.show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {

        TextView id,name,surname,std;
        Button b1,b2;


        public StudentHolder(@NonNull View itemView) {
            super(itemView);

            id =itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            std=itemView.findViewById(R.id.std);

            b1=itemView.findViewById(R.id.b1);
            b2=itemView.findViewById(R.id.b2);

        }
    }
}
