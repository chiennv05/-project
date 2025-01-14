package fpoly.chiennvph50713_duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import fpoly.chiennvph50713_duanmau.database.DBHelper;
import fpoly.chiennvph50713_duanmau.model.Sach;

public class SachDAO {
    private DBHelper dbHelper;
    Context context;

    public SachDAO(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public ArrayList<Sach> dsSach() {
        ArrayList<Sach> list_Sach = new ArrayList<>();
        String truyvan = "SELECT sc.masach,sc.tensach,sc.giathue,sc.maloai,ls.tenloai,sc.soluong_ph44878,sc.sotrang_ph44878  FROM SACH sc,LOAISACH ls WHERE sc.maloai = ls.maloai";
        Cursor ketqua = dbHelper.getReadableDatabase().rawQuery(truyvan, null);
        if (ketqua.getCount() > 0) {
            if (ketqua.moveToFirst()) {
                do {
                    Sach sach = new Sach();
                    sach.setMasach(ketqua.getInt(0));
                    sach.setTensach(ketqua.getString(1));
                    sach.setGiathue(ketqua.getInt(2));
                    sach.setMaloai(ketqua.getInt(3));
                    sach.setTenloai(ketqua.getString(4));
                    sach.setSoluong(ketqua.getInt(5));
                    sach.setSotrang(ketqua.getString(6));
                    list_Sach.add(sach);
                } while (ketqua.moveToNext());
            }
        }
        return list_Sach;
    }

    public boolean addSach(String tensach, int giathue, int maloai,String sotrang) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tensach", tensach);
        values.put("giathue", giathue);
        values.put("maloai", maloai);
        values.put("sotrang_ph44878",sotrang);

        long check = database.insert("SACH", null, values);
        if (check == -1) {
            return false;
        }
        return true;
    }
    public boolean deleteSach(int masach) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long check = database.delete("SACH", "masach = ?", new String[]{String.valueOf(masach)});
        if (check > 0) {
            Toast.makeText(context, "Xoá sách thành công", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(context, "Xoá thất bại", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean updataSach(int masach,String tensach,int giathue,int maloai){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masach",masach);
        values.put("tensach", tensach);
        values.put("giathue", giathue);
        values.put("maloai", maloai);
        long check = database.update("SACH",values,"masach = ?",new String[]{String.valueOf(masach)});
        if (check !=-1){
            return true;
        } return false;
    }
    public boolean updateSoluong(int soluong){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soluong_ph44878",soluong);

        long check = database.update("SACH",values,"masach = ?",new String[]{String.valueOf(soluong)});
        if (check !=-1){
            return true;
        } return false;
    }
}
