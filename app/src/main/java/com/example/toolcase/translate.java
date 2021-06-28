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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class translate extends AppCompatActivity {
    private static final String APP_ID = "20201204000636767";
    private static final String SECURITY_KEY = "nspz3kPA3Tv4hjf3DPNW";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        TextView xianshi=findViewById(R.id.xianshi);
        EditText shuru=findViewById(R.id.shuru);
        Button fanyi=findViewById(R.id.fanyi);
        fanyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

                        String query = shuru.getText().toString();
                        String abc=null;
                        byte []bytes = query.getBytes();
                        int i = bytes.length;//i为字节长度
                        int j = query.length();//j为字符长度
                        if (i==j){ abc=api.getTransResult(query, "auto", "zh");}
                        else abc=api.getTransResult(query, "zh", "en");
                        Log.d("abc",abc);
                        try {
                            JSONObject json=new JSONObject(abc);
                            String bcd=json.optString("trans_result");
                            Log.d("bcd",bcd);
                            JSONArray json1=new JSONArray(bcd);
                            JSONObject json2=json1.getJSONObject(0);
                            String cde=json2.optString("dst");
                            Log.d("cde",cde);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    xianshi.setText(cde);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }).start();
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
        Toast.makeText(this,"利用了百度翻译的接口，支持中英互译",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}