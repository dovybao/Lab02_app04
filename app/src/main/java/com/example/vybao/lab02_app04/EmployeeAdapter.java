package com.example.vybao.lab02_app04;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Activity context = null;
    ArrayList<Employee> myArray = null;
    int layoutID;

    public EmployeeAdapter(Activity context, int layoutID, ArrayList<Employee> arr) {
        super(context, layoutID, arr);
        this.context = context;
        this.layoutID = layoutID;
        this.myArray = arr;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);

        final LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_employee_ll_parent);

        if (myArray.size() > 0 && position >= 0) {
            final TextView txtdiplay = (TextView) convertView.findViewById(R.id.tvName);
            final Employee employee = myArray.get(position);

            txtdiplay.setText(employee.toString());

            final TextView txtStaff = (TextView) convertView.findViewById(R.id.tvStaff);
            final ImageView imgManager = (ImageView) convertView.findViewById(R.id.imageManager);

            if (employee.isManager()) {
                imgManager.setVisibility(View.VISIBLE);
                txtStaff.setVisibility(View.GONE);
            } else {
                imgManager.setVisibility(View.GONE);
                txtStaff.setVisibility(View.VISIBLE);

            }


        }
        if (position % 2 == 0) {
            llParent.setBackgroundResource(R.color.white);
        } else {
            llParent.setBackgroundResource(R.color.light_blue);
        }
        return convertView;
    }
}