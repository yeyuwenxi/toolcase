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
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class todayinhistory extends AppCompatActivity {
    private String a;
    private String b;
    private String c;
    private String d;
    Myadapater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todayinhistory);
        //http://v.juhe.cn/todayOnhistory/queryEvent.php?key=0b4da8a515b52b38920dc801b0459fab&date=1/1
        EditText riqi=findViewById(R.id.riqi);
        Button chaxun1=findViewById(R.id.chaxun1);
        //TextView text2=findViewById(R.id.text2);

        chaxun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a="http://v.juhe.cn/todayOnhistory/queryEvent.php?key=0b4da8a515b52b38920dc801b0459fab&date=";
                b=riqi.getText().toString();
                d=a+b;
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
        Toast.makeText(this,"利用了网络上的API接口，可以查询历史上的今天发生的事件",Toast.LENGTH_SHORT).show();
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

                   // Log.i("response",response.toString());

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
        Log.i("0123","123");
        Gson gson=new Gson();
        Log.i("8123","123");
        JsonRootBean jsonRootBean=gson.fromJson(response,JsonRootBean.class);
        Log.i("123","123");
        List<Result> result=jsonRootBean.getResult();
        Log.i("234","123");
        Log.i("result",result.toString());

        Result result1=result.get(1);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("345","123");
                // 在这里进行UI操作，将结果显示到界面上
                ListView list=findViewById(R.id.list);
               adapter=new Myadapater(todayinhistory.this,4,R.layout.listitem,result);

                list.setAdapter(adapter);



            }
        });
    }
    public class JsonRootBean {

        private String reason;
        private List<Result> result;
        private int error_code;
        public void setReason(String reason) {
            this.reason = reason;
        }
        public String getReason() {
            return reason;
        }

        public void setResult(List<Result> result) {
            this.result = result;
        }
        public List<Result> getResult() {
            return result;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }
        public int getError_code() {
            return error_code;
        }

    }
    public class Result {

        private String day;
        private String date;
        private String title;
        private String e_id;
        public void setDay(String day) {
            this.day = day;
        }
        public String getDay() {
            return day;
        }

        public void setDate(String date) {
            this.date = date;
        }
        public String getDate() {
            return date;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }
        public String getE_id() {
            return e_id;
        }

    }

}