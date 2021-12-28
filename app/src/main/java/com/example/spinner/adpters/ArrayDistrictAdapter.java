package com.example.spinner.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spinner.R;
import com.example.spinner.models.District;
import com.example.spinner.models.Province;

import java.util.List;

public class ArrayDistrictAdapter extends ArrayAdapter<District> {
    public ArrayDistrictAdapter(@NonNull Context context, int resource, @NonNull List<District> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_spinner,parent,false);
        TextView tvProvince = view.findViewById(R.id.tv_province);
        District province = this.getItem(position);
        if(province!=null){
            tvProvince.setText(province.getName());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner,parent,false);
        TextView tvProvince = view.findViewById(R.id.tv_spinner_province);
        District province = this.getItem(position);
        if(province!=null){
            tvProvince.setText(province.getName());
        }
        return view;
    }
}
