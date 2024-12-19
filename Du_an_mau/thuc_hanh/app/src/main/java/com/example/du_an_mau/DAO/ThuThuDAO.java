package com.example.du_an_mau.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_mau.DbHelper.MyHelper;
import com.example.du_an_mau.Model.ThuThu;

public class ThuThuDAO {

    MyHelper myHelper;

    SQLiteDatabase db;

    Context context;

    public ThuThuDAO(Context context) {
        this.context = context;
        myHelper = new MyHelper(context);
        db = myHelper.getWritableDatabase();
    }

    public ThuThu checklogin(String matt, String matkhau) {
        ThuThu thuThu = null;
        String[] dieuKien = new String[]{matt, matkhau};
        Cursor cursor = db.rawQuery("SELECT * FROM thuthu WHERE matt = ? AND matkhau = ?", dieuKien);
        if (cursor != null && cursor.getCount()==1) {
            //có thông tin
            cursor.moveToFirst();//dùng để di chuyển con trỏ
            //thứ tự các cột trong bảng bắt đầu thừ 0
            thuThu = new ThuThu(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            cursor.close();
        }
        return thuThu;

    }
}
