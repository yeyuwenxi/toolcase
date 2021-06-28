package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Qrcode extends AppCompatActivity {
   private String a;
   private String b;
   private String c;
    private String d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        //草料二维码api
        //https://cli.im/api/qrcode/code?text=123&mhid=vULOBAzvncIhMHYsLddVPak
        EditText neirong=findViewById(R.id.neirong);
        Button shengcheng=findViewById(R.id.shengcheng);
        WebView erweima=findViewById(R.id.erweima);
        shengcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a="https://cli.im/api/qrcode/code?text=";
                b=neirong.getText().toString();
                c="&mhid=vULOBAzvncIhMHYsLddVPak";
                d=a+b+c;
                erweima.getSettings().setJavaScriptEnabled(true);
                //适应手机屏幕
                //erweima.getSettings().setUseWideViewPort(true);
                //erweima.getSettings().setLoadWithOverviewMode(true);
                //erweima.setWebViewClient(new WebViewClient());
           erweima.loadUrl(d);


                //sendRequestWithHttpURLConnection();
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
        Toast.makeText(this,"利用了草料二维码的API，通过网络返回含二维码的html文档",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL(d);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    // 下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    Log.i("response",response.toString());
                   // parseJSONWithJSONObject(response.toString());
                    // showResponse(response.toString());
                    //Ui线程
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

}