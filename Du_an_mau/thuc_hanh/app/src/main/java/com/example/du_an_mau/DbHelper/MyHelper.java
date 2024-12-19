package com.example.du_an_mau.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    static String Db_Name = "duan";

    static int Db_VERSION = 2;

    public MyHelper(Context context) {
        super(context, Db_Name, null, Db_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_tb_thuthu = "CREATE TABLE thuthu (matt text primary key, hoten text not null, matkhau text not null, quyen integer default 0  )";
        // quyen : 0 la thu thư, 1 là admin   hoặc có thể đặt kiểu dữ liệu chuỗi
        sqLiteDatabase.execSQL( sql_tb_thuthu );
        // thêm sẵn thủ thư
        String sql_insert_thuthu = "INSERT INTO thuthu VALUES ('tt01', 'Nguyen Van A', '123', 0)";
        sqLiteDatabase.execSQL(sql_insert_thuthu);
        // viết tương tự cho các bảng khác


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1 > i) {
            //có nâng phiên bản,  viết lệnh alter table hoặc drop rồi tạo lại
            sqLiteDatabase.execSQL("drop table if exists thuthu");
            onCreate(sqLiteDatabase);//tạo lại bảng
        }
    }
}
