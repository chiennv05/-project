package fpoly.chiennvph50713_duanmau.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import fpoly.chiennvph50713_duanmau.database.DBHelper;
import fpoly.chiennvph50713_duanmau.model.Sach;

public class Top10sachmuonDAO {
    private DBHelper dbHelper;
    Context context;

    public Top10sachmuonDAO(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public ArrayList<Sach> top10sach() {
        ArrayList<Sach> list_top10 = new ArrayList<>();
        String truyvan = "SELECT pm.masach, sc.tensach, COUNT(pm.masach)\n" +
                "FROM PHIEUMUON pm, SACH sc \n" +
                "WHERE pm.masach = sc.masach\n" +
                "GROUP BY pm.masach, sc.tensach\n" +
                "ORDER BY COUNT(pm.masach) DESC\n" +
                "LIMIT 10";
        Cursor ketqua = dbHelper.getReadableDatabase().rawQuery(truyvan, null);
        if (ketqua.getCount() > 0) {
            if (ketqua.moveToFirst()) {
                do {
                    list_top10.add(new Sach(ketqua.getInt(0), ketqua.getString(1), ketqua.getInt(2)));
                } while (ketqua.moveToNext());
            }
        }
        return list_top10;
    }



}




