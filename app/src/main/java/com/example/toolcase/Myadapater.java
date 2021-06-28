package com.example.toolcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Myadapater extends ArrayAdapter<todayinhistory.Result> {

   int resourseid;

    public Myadapater(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<todayinhistory.Result> objects) {
        super(context, resource, textViewResourceId, objects);
        resourseid=textViewResourceId;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        todayinhistory.Result result=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseid,parent,false);
        //TextView text1=view.findViewById(R.id.text1);
        TextView text2=view.findViewById(R.id.text2);
        TextView text3=view.findViewById(R.id.text3);
        //TextView text4=view.findViewById(R.id.text4);
        //text1.setText(result.getDay());
        text2.setText(result.getDate());
        text3.setText(result.getTitle());
       // text4.setText(result.getE_id());
        return view;


    }
}
