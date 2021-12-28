package com.example.spinner.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.spinner.models.District;
import com.example.spinner.models.Province;

import java.util.ArrayList;
import java.util.List;

public class ProvinceDAO {
    private MySqliteOpenHelper mySqliteOpenHelper;
    public ProvinceDAO(Context context) {
        this.mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }
    private String TABLE_NAME = "province";
    private String ID = "id";
    private String NAME = "name";
    private String TYPE = "type";

    public List<Province> getAll() {
        List<Province> provinceList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Province province = new Province();
                    province.setId(cursor.getString(cursor.getColumnIndex(ID)));
                    province.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                    province.setType(cursor.getString(cursor.getColumnIndex(TYPE)));
                    provinceList.add(province);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return provinceList;
    }
}
