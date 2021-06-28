package com.example.toolcase.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.toolcase.Qrcode;
import com.example.toolcase.R;
import com.example.toolcase.chengyuchaxun;
import com.example.toolcase.daojishi;
import com.example.toolcase.huaban;
import com.example.toolcase.jinzhizhuanhuan;
import com.example.toolcase.kebiao;
import com.example.toolcase.meiriyitu;
import com.example.toolcase.shudu;
import com.example.toolcase.suijishu;
import com.example.toolcase.todayinhistory;
import com.example.toolcase.translate;
import com.example.toolcase.xinhuazidian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView=root.findViewById(R.id.grid);

         SimpleAdapter adapter;

         List<Map<String, Object>> datas;
        datas = new ArrayList<Map<String, Object>>();
         Map<String,Object> map1=new HashMap<String, Object>();
         map1.put("image",R.drawable.erweima);
         map1.put("text","二维码生成");
         datas.add(map1);
        Map<String,Object> map2=new HashMap<String, Object>();
        map2.put("image",R.drawable.dancichaxun);
        map2.put("text","单词翻译");
        datas.add(map2);
        Map<String,Object> map3=new HashMap<String, Object>();
        map3.put("image",R.drawable.chengyuchaxun);
        map3.put("text","成语查询");
        datas.add(map3);
        Map<String,Object> map4=new HashMap<String, Object>();
        map4.put("image",R.drawable.xinhuazidian);
        map4.put("text","新华字典");
        datas.add(map4);

        Map<String,Object> map5=new HashMap<String, Object>();
        map5.put("image",R.drawable.todayinhistory);
        map5.put("text","历史上的今天");
        datas.add(map5);

        Map<String,Object> map6=new HashMap<String, Object>();
        map6.put("image",R.drawable.meiriyitu);
        map6.put("text","每日一图");
        datas.add(map6);
        Map<String,Object> map7=new HashMap<String, Object>();
        map7.put("image",R.drawable.daojishi);
        map7.put("text","倒计时");
        datas.add(map7);
        Map<String,Object> map8=new HashMap<String, Object>();
        map8.put("image",R.drawable.huaban);
        map8.put("text","画板");
        datas.add(map8);
        Map<String,Object> map9=new HashMap<String, Object>();
        map9.put("image",R.drawable.kebiao);
        map9.put("text","课表查询");
        datas.add(map9);
        Map<String,Object> map10=new HashMap<String, Object>();
        map10.put("image",R.drawable.jinzhizhuanhuan);
        map10.put("text","进制转换");
        datas.add(map10);
        Map<String,Object> map11=new HashMap<String, Object>();
        map11.put("image",R.drawable.suijishu);
        map11.put("text","随机数生成");
        datas.add(map11);
        Map<String,Object> map12=new HashMap<String, Object>();
        map12.put("image",R.drawable.shudu);
        map12.put("text","数独");
        datas.add(map12);



        adapter = new SimpleAdapter(getContext(), datas, R.layout.item,new String[] { "image", "text" },new int[] { R.id.image, R.id.text });
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 5:{
                        Intent intent7=new Intent();
                        intent7.setClass(getActivity(), meiriyitu.class);
                        startActivity(intent7);
                        break;
                    }
                    case 1:{
                        Intent intent1=new Intent();
                        intent1.setClass(getActivity(), translate.class);
                        startActivity(intent1);
                        break;
                    }
                    case 0:{
                        Intent intent0=new Intent();
                        intent0.setClass(getActivity(), Qrcode.class);
                        startActivity(intent0);
                        break;
                    }
                    case 2:{
                        Intent intent2=new Intent();
                        intent2.setClass(getActivity(), chengyuchaxun.class);
                        startActivity(intent2);
                        break;
                    }
                    case 3:{
                        Intent intent3=new Intent();
                        intent3.setClass(getActivity(), xinhuazidian.class);
                        startActivity(intent3);
                        break;
                    }

                    case 4:{
                        Intent intent4=new Intent();
                        intent4.setClass(getActivity(), todayinhistory.class);
                        startActivity(intent4);
                        break;
                    }
                    case 6:{
                        Intent intent6=new Intent();
                        intent6.setClass(getActivity(), daojishi.class);
                        startActivity(intent6);
                        break;
                    }
                    case 7:{
                        Intent intent7=new Intent();
                        intent7.setClass(getActivity(), huaban.class);
                        startActivity(intent7);
                        break;
                    }
                    case 8:{
                        Intent intent8=new Intent();
                        intent8.setClass(getActivity(), kebiao.class);
                        startActivity(intent8);
                        break;
                    }
                    case 9:{
                        Intent intent9=new Intent();
                        intent9.setClass(getActivity(), jinzhizhuanhuan.class);
                        startActivity(intent9);
                        break;
                    }
                    case 10:{
                        Intent intent10=new Intent();
                        intent10.setClass(getActivity(), suijishu.class);
                        startActivity(intent10);
                        break;
                    }
                    case 11:{
                        Intent intent11=new Intent();
                        intent11.setClass(getActivity(), shudu.class);
                        startActivity(intent11);
                        break;
                    }

                }
            }
        });






        return root;
    }
}