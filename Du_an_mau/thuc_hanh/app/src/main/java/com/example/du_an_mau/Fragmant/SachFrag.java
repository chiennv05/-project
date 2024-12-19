package com.example.du_an_mau.Fragmant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.du_an_mau.R;

public class SachFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //nhung layout
        return  inflater.inflate(R.layout.layout_frag_sach
        , container, false);//gắn layput cho frag

    }
    //xu ly su kien tuong tac trong view trong layout


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //xu lý su kien tuong tac voi view trong layout
        //ví dujL tương tác với textvieww
        TextView tv01 = view.findViewById(R.id.tv01);
        tv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goi context thi dung getcontext hoac getActyvity
                Toast.makeText(getContext(), "Bạn đã bấm vào text view", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
