package fpoly.chiennvph50713_duanmau.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fpoly.chiennvph50713_duanmau.R;


public class ChaoActivity extends AppCompatActivity {
    EditText edt_mssv;
    Button btn_startSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fpoly.chiennvph50713_duanmau.R.layout.activity_chao);
        edt_mssv = findViewById(R.id.edt_mssv);
        btn_startSV = findViewById(R.id.btn_startSV);

        btn_startSV.setOnClickListener(v -> {
            String mssv = edt_mssv.getText().toString();
            if (mssv.isEmpty()){
                Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                if (mssv.equals("PH44878")){
                    startActivity(new Intent(ChaoActivity.this, LoginActivity.class));
                } else {
                    showDialog();
                }
            }

        });
    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.warning);
        builder.setTitle("Lỗi");
        builder.setMessage("Nhập sai mã sinh viên ");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}