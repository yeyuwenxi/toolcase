package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class daojishi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daojishi);
        TextView shijian=findViewById(R.id.text_shijian);
        Button xuanze=findViewById(R.id.xuanze);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");






        //shijian.setText("相差"+String.valueOf(day)+"天"+String.valueOf(hour)+"小时"+String.valueOf(minute)+"分");
         //shijian.setText("当前日期时间"+simpleDateFormat.format(date));
        xuanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(daojishi.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String mubiao=year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日";
                        long time = 0;
                        long day = 0;
                        try {
                            Date mubiao1=simpleDateFormat.parse(mubiao);
                            Date now = new Date(System.currentTimeMillis());
                            time =mubiao1.getTime()-now.getTime();
                            day = time /(1000*60*60*24);

                              day=day+1;

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        shijian.setText("距离"+mubiao+"还有"+day+"天");

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"设置指定时间，并显示和当前日期的距离",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}