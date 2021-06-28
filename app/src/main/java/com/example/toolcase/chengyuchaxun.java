package com.example.toolcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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

public class chengyuchaxun extends AppCompatActivity {
    private String a;
    private String b;
    private String c;
    private String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyuchaxun);
        //聚合数据成语大全api
        //http://apis.juhe.cn/idioms/query?key=71fc4bf0ae5c137add32b9b32e34aa70&wd=%E5%8D%81%E5%85%A8%E5%8D%81%E7%BE%8E

        EditText chengxu=findViewById(R.id.chengyu);
        Button chaxun=findViewById(R.id.chaxun);

        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

      a="http://apis.juhe.cn/idioms/query?key=71fc4bf0ae5c137add32b9b32e34aa70&wd=";
      b=chengxu.getText().toString();
       //汉字编码为utf-8
        try {
            c= URLEncoder.encode(b,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
           Log.i("c",c);
                d=a+c;

      //十全十美




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
        Toast.makeText(this,"利用了网络的API返回数据，若输入的不是成语，则返回为空",Toast.LENGTH_SHORT).show();
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
                TextView text1=findViewById(R.id.text1);
              // text1.setText(response);

                try {
                    JSONObject json = new JSONObject(response);
                    String result=json.optString("result");
                    JSONObject json1 = new JSONObject(result);

                    String name=json1.optString("name");
                    String pinyin=json1.optString("pinyin");
                    String xxsy=json1.optString("xxsy");
                    String chuchu=json1.optString("chuchu");
                    String jyc=json1.optString("jyc");
                    String fyc=json1.optString("fyc");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String abc="成语："+name+'\n'+ "拼音："+pinyin+'\n'+"含义："+xxsy+'\n'+"出处："+chuchu+'\n'+"同义词："+jyc+'\n'+"反义词："+fyc;
                            text1.setText(abc);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}