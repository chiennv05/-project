package fpoly.chiennvph50713_duanmau.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "quanlithuvien", null, 25);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tạo data
        String sqlThuthu = "CREATE TABLE THUTHU ( matt TEXT PRIMARY KEY, hotentt TEXT, matkhau TEXT)\n";
        db.execSQL(sqlThuthu);
        String sqlThanhvien = "CREATE TABLE THANHVIEN( matv INTEGER PRIMARY KEY AUTOINCREMENT, hoten TEXT, namsinh TEXT,gioitinh_ph44878 INTEGER,stk INTEGER)\n"; //0 là nam, 1 là nữ
        db.execSQL(sqlThanhvien);
        String sqlLoaisach = "CREATE TABLE LOAISACH( maloai INTEGER PRIMARY KEY AUTOINCREMENT, tenloai TEXT)\n";
        db.execSQL(sqlLoaisach);
        String sqlSach = "CREATE TABLE SACH ( masach INTEGER PRIMARY KEY AUTOINCREMENT, tensach TEXT, giathue INTEGER, maloai INTEGER REFERENCES LOAISACH(maloai),soluong_ph44878 INTEGER,sotrang_ph44878 TEXT )\n";
        db.execSQL(sqlSach);
        String sqlPhieumuon = "CREATE TABLE PHIEUMUON ( mapm INTEGER PRIMARY KEY AUTOINCREMENT, matv INTEGER REFERENCES THANHVIEN(matv), matt TEXT REFERENCES THUTHU(matt),masach INTEGER REFERENCES SACH(masach), ngay TEXT,trasach INTEGER,tienthue INTEGER,gio TEXT)\n";
        db.execSQL(sqlPhieumuon);

        //fix cứng dữ liệu
        db.execSQL("INSERT INTO THUTHU VALUES ('thuthu01', 'Nguyễn Văn Chiến', '1234'), \n" +
                "                           ('thuthu02', 'Nguyễn Tiến Đạt', 'ph44878'), \n" +
                "                          ('thuthu03', 'Nguyễn Đăng Nam', '12345');");

        //1 là trả sách, 0 là chưa trả
//        db.execSQL("INSERT INTO PHIEUMUON VALUES (1, 1, 'thuthu01', 1, '2024-08-11', 1, 2500)");
//        db.execSQL("INSERT INTO PHIEUMUON VALUES (2, 2, 'thuthu02', 2, '2024-08-21', 0, 3500)");
//        db.execSQL("INSERT INTO PHIEUMUON VALUES (3, 3, 'thuthu03', 3, '2024-09-11', 1, 4500)");

    }

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion)
            db.execSQL("DROP TABLE IF EXISTS THUTHU");
        db.execSQL("DROP TABLE IF EXISTS THANHVIEN");
        db.execSQL("DROP TABLE IF EXISTS LOAISACH");
        db.execSQL("DROP TABLE IF EXISTS SACH");
        db.execSQL("DROP TABLE IF EXISTS PHIEUMUON");
        onCreate(db);
    }
}
