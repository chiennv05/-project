package com.example.du_an_mau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.du_an_mau.DAO.ThuThuDAO;
import com.example.du_an_mau.Model.ThuThu;

public class LoginActivity extends AppCompatActivity {

    ThuThuDAO thuThuDAO;

    EditText edmatt, edmatkhau;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login  );
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ
        edmatt = findViewById(R.id.edmatt);
        edmatkhau = findViewById(R.id.edmatkhau);
        btnLogin = findViewById(R.id.btnlogin);
        //khợi tạo các biến
        thuThuDAO = new ThuThuDAO(this);
        //xử lsy hành vi
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //nội dung người dùng nhập vào
                String matt = edmatt.getText().toString();
                String matkhau = edmatkhau.getText().toString();
                //kiểm tra hợp lệ
                if(matt.length() < 3) {
                    Toast.makeText(LoginActivity.this, "Mã Cần Nhập ít nhất 3 ký tự", Toast.LENGTH_SHORT).show();
                    return;//thoát khỏi hàm
                }

                ThuThu kqThuThu = thuThuDAO.checklogin(matt, matkhau);
                if(kqThuThu != null) {
                    //đúng thông tin login
                    //lưu đăng nhập nếu có
                    //gọi activity chính
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();//đóng 1 activity
                    

                }else {
                    Toast.makeText(LoginActivity.this, "Sai Thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}