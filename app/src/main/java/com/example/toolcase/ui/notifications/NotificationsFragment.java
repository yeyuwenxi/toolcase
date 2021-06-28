package com.example.toolcase.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.toolcase.R;

public class NotificationsFragment extends Fragment {

    //private ArrayAdapter<String> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


       /* ListView list2=root.findViewById(R.id.list2);
        List<String> datas=new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,datas);
        datas.add("设置");
        datas.add("关于");
        datas.add("反馈");


        list2.setAdapter(adapter);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        Intent intent0=new Intent();
                        intent0.setClass(getActivity(), shezhi.class);
                        startActivity(intent0);
                        break;
                    }
                    case 1:{
                        Intent intent1=new Intent();
                        intent1.setClass(getActivity(), guanyu.class);
                        startActivity(intent1);
                        break;
                    }
                    case 2:{
                        Intent intent2=new Intent();
                        intent2.setClass(getActivity(), fankui.class);
                        startActivity(intent2);
                        break;
                    }




                }
            }
        });*/
        return root;
    }
}