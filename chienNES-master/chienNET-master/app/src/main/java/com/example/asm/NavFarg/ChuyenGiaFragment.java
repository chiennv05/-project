package com.example.asm.NavFarg;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ChuyenGiaFragment extends Fragment {
//    private EditText edName, edEmail, edmatkhau, edXacNhan;
//    private Button btnSubmit;
//    private FirebaseFirestore firestore;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_chuyen_gia, container, false);
//        edName = view.findViewById(R.id.edName);
//        edEmail = view.findViewById(R.id.edEmail);
//        edmatkhau = view.findViewById(R.id.edMatkhauChuyengia);
//        edXacNhan = view.findViewById(R.id.edXacNhanMatKhau);
//        btnSubmit = view.findViewById(R.id.btnSubmit);
//        firestore = FirebaseFirestore.getInstance();
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = edName.getText().toString();
//                String email = edEmail.getText().toString();
//                String matKhau = edmatkhau.getText().toString();
//                String xacNhan = edXacNhan.getText().toString();
//
//                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(matKhau) || TextUtils.isEmpty(xacNhan)) {
//                    Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                Map<String, Object> chuyenGia = new HashMap<>();
//                chuyenGia.put("name", name);
//                chuyenGia.put("email", email);
//                chuyenGia.put("matkhau", matKhau);
//                chuyenGia.put("xacnhan", xacNhan);
//
//                firestore.collection("chuyengia").add(chuyenGia)
//                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(getActivity(), "Thêm chuyên gia thành công", Toast.LENGTH_SHORT).show();
//                                    edName.setText("");
//                                    edEmail.setText("");
//                                    .setText("");
//                                } else {
//                                    Toast.makeText(getActivity(), "Lỗi khi thêm chuyên gia", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//            }
//        });
//        return view;
//    }
}


