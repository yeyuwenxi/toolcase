package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

public class xinhuazidian extends AppCompatActivity {
    private String a;
    private String b;
    private String c;
    private String d;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinhuazidian);
        //http://v.juhe.cn/xhzd/query?key=fe668c58517355565ea93e9580804240&word=%E8%81%9A
        EditText zi=findViewById(R.id.zi);
        Button chaxun=findViewById(R.id.chaxun);

        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a="http://v.juhe.cn/xhzd/query?key=fe668c58517355565ea93e9580804240&word=";
                b=zi.getText().toString();
                //汉字编码为utf-8
                try {
                    c= URLEncoder.encode(b,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Log.i("c",c);
                d=a+c;






                sendRequestWithHttpURLConnection();
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
        Toast.makeText(this,"利用了网络的API接口实现汉字查询",Toast.LENGTH_SHORT).show();
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
                    showResponse(response.toString());
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

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                //TextView text1=findViewById(R.id.text1);
                try {
                    JSONObject json = new JSONObject(response);
                    String result=json.optString("result");
                    JSONObject json1 = new JSONObject(result);

                    String jijie= json1.optString("jijie");


                            String jianjie=jijie.substring(1,jijie.length()-1);
                        List<String> abc= Arrays.asList(jianjie.split(","));

                            ListView list1=findViewById(R.id.list1);
                            adapter = new ArrayAdapter<>(xinhuazidian.this,android.R.layout.simple_list_item_1,abc);

                            list1.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}