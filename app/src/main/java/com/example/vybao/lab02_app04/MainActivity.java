package com.example.vybao.lab02_app04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee>arrEmployee = new ArrayList<Employee>();

    EmployeeAdapter adapter = null;
    ListView lvEmployee = null;

    Button btnNhap;
    EditText editMa,editTen;
    CheckBox position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = (Button)findViewById(R.id.btnNhap);
        editMa = (EditText)findViewById(R.id.inputMaNV);
        editTen = (EditText)findViewById(R.id.inputTenNV);

        position = (CheckBox)findViewById(R.id.cbPosition);
        lvEmployee = (ListView)findViewById(R.id.lvNhanVien);


        adapter = new EmployeeAdapter(this,R.layout.my_item_layout,arrEmployee);
        lvEmployee.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNhap();
            }
        });




    }
    public void processNhap(){
        String id = editMa.getText().toString();
        String  name = editTen.getText().toString();

        boolean isamanager = position.isChecked();

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setPosition(isamanager);

        arrEmployee.add(employee);
        adapter.notifyDataSetChanged();
    }
}
