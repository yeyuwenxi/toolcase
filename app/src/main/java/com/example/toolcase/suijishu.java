package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class suijishu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suijishu);
        Button shengcheng=findViewById(R.id.shengcheng);
        EditText min=findViewById(R.id.min);
        EditText max=findViewById(R.id.max);
        TextView text1=findViewById(R.id.text_random);
        shengcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String min1=min.getText().toString();
                int min2=Integer.valueOf(min1);
                String max1=max.getText().toString();
                int max2=Integer.valueOf(max1);
               Random rand=new Random();
                int randomnum=rand.nextInt(max2-min2+1)+min2;
                text1.setText(Integer.toString(randomnum));
            }
        });

        //int randNumber =rand.nextInt(MAX - MIN + 1) + MIN
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"生成指定范围内的随机数",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}