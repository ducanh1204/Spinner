package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spinner.adpters.ArrayDistrictAdapter;
import com.example.spinner.adpters.ArrayProvinceAdapter;
import com.example.spinner.models.District;
import com.example.spinner.models.Province;
import com.example.spinner.sqlite.DistrictDAO;
import com.example.spinner.sqlite.MySqliteOpenHelper;
import com.example.spinner.sqlite.ProvinceDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DistrictDAO districtDAO;
    private ProvinceDAO provinceDAO;
    private List<Province> provinceList;
    private List<District> districtList;
    private Spinner spinner1,spinner2;
    private String currentProvinceId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinner_1);
        spinner2 = findViewById(R.id.spinner_2);
        MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(this);
        mySqliteOpenHelper.createDataBase();
        districtDAO = new DistrictDAO(this);
        provinceDAO = new ProvinceDAO(this);
        provinceList = provinceDAO.getAll();
        ArrayProvinceAdapter arrayProvinceAdapter = new ArrayProvinceAdapter(this,R.layout.view_spinner,provinceList);
        spinner1.setAdapter(arrayProvinceAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentProvinceId = provinceList.get(position).getId();
                viewSpinner2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void viewSpinner2(){
        districtList = districtDAO.getByProvince(currentProvinceId);
        ArrayDistrictAdapter arrayDistrictAdapter = new ArrayDistrictAdapter(this,R.layout.view_spinner,districtList);
        spinner2.setAdapter(arrayDistrictAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}