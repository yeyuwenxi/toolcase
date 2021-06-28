package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class huaban extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huaban);



       MySurfaceView mview = findViewById(R.id.view);

        Button qingchu =  findViewById(R.id.qingchu);

       qingchu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mview.reset();
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
        Toast.makeText(this,"自由涂鸦的画板",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}