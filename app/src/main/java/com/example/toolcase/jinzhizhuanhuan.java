package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class jinzhizhuanhuan extends AppCompatActivity {
    int from;
    int to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhizhuanhuan);
        RadioGroup group1=findViewById(R.id.group1);
        RadioGroup group2=findViewById(R.id.group2);
        Button zhuanhuan=findViewById(R.id.zhuanhuan);
        EditText shuru=findViewById(R.id.shuru);
        EditText jieguo=findViewById(R.id.jieguo);




            group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case R.id.two:{
                            from=2;

                            break;}
                        case R.id.eight:{
                            from=8;

                            break;}
                        case R.id.ten:{
                            from=10;

                            break;}
                        case R.id.sixteen:{
                            from=16;

                            break;}


                    }
                }
            });
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.second:{
                        to=2;

                        break;}
                    case R.id.eighth:{
                        to=8;

                        break;}
                    case R.id.tenth:{
                        to=10;

                        break;}
                    case R.id.sixteenth:{
                        to=16;

                        break;}


                }
            }
        });
        zhuanhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=shuru.getText().toString();

                if (from==2){
                    if(to==2){
                        int b=Integer.valueOf(a,2);
                        jieguo.setText(Integer.toBinaryString(b));
                    }
                    else if(to==8){
                        int b=Integer.valueOf(a,2);
                        jieguo.setText(Integer.toOctalString(b));
                    }
                    else if(to==10){
                        int b=Integer.valueOf(a,2);
                        jieguo.setText(Integer.toString(b));
                    }
                    else if(to==16){
                        int b=Integer.valueOf(a,2);
                        jieguo.setText(Integer.toHexString(b));
                    }

                }
                else if(from==8){
                    if(to==2){
                        int b=Integer.valueOf(a,8);
                        jieguo.setText(Integer.toBinaryString(b));
                    }
                    else if(to==8){
                        int b=Integer.valueOf(a,8);
                        jieguo.setText(Integer.toOctalString(b));
                    }
                    else if(to==10){
                        int b=Integer.valueOf(a,8);
                        jieguo.setText(Integer.toString(b));
                    }
                    else if(to==16){
                        int b=Integer.valueOf(a,8);
                        jieguo.setText(Integer.toHexString(b));
                    }

                }
                else if(from==10){
                    if(to==2){
                        int b=Integer.valueOf(a);
                        jieguo.setText(Integer.toBinaryString(b));
                    }
                    else if(to==8){
                        int b=Integer.valueOf(a);
                        jieguo.setText(Integer.toOctalString(b));
                    }
                    else if(to==10){

                        jieguo.setText(a);
                    }
                    else if(to==16){
                        int b=Integer.valueOf(a);
                        jieguo.setText(Integer.toHexString(b));
                    }

                }
                else if(from==16){
                    if(to==2){
                        int b=Integer.valueOf(a,16);
                        jieguo.setText(Integer.toBinaryString(b));
                    }
                    else if(to==8){
                        int b=Integer.valueOf(a,16);
                        jieguo.setText(Integer.toOctalString(b));
                    }
                    else if(to==10){
                        int b=Integer.valueOf(a,16);
                        jieguo.setText(Integer.toString(b));
                    }
                    else if(to==16){

                        int b=Integer.valueOf(a,16);
                        jieguo.setText(Integer.toHexString(b));
                    }

                }
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
        Toast.makeText(this,"支持常用进制之间的转换",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

}