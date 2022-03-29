package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    Activity activity;
    List<StudentData> dataList;

    public StudentAdapter(Activity activity , List<StudentData> dataList){
        this.activity=activity;
        this.dataList=dataList;

    }
    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.list_item,parent,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {


        holder.id.setText("ID : "+dataList.get(position).id+"");
        holder.name.setText("NAME : "+dataList.get(position).name);
        holder.surname.setText("SURNAME : "+dataList.get(position).surname);
        holder.std.setText("STD : "+dataList.get(position).std);

    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {

         public TextView id,name,surname,std;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);

            id =itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            std=itemView.findViewById(R.id.std);

        }
    }
}
