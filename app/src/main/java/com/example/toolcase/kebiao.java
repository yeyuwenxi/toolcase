package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class kebiao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebiao);
        WebView kebiao=findViewById(R.id.kebiao);
        kebiao.getSettings().setJavaScriptEnabled(true);
        kebiao.setWebViewClient(new WebViewClient());
        kebiao.loadUrl("https://everyclass.xyz");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"支持查询中南大学的课表，数据由每课提供",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}