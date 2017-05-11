package com.roksagmail.bd_lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddRecords extends AppCompatActivity {
    ImageView ivBack;
    Button btnAdd;
    EditText etDate;
    EditText etName;
    EditText etRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);
        ivBack=(ImageView)findViewById(R.id.ivBack);
        btnAdd=(Button)findViewById(R.id.btnAddRecord);
        etDate=(EditText)findViewById(R.id.ed_Date);
        etName=(EditText)findViewById(R.id.ed_Name);
        etRecord=(EditText)findViewById(R.id.ed_Count);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().length()==0||etDate.getText().toString().trim().length()==0||etRecord.getText().toString().trim().length()==0)
                {
                    Toast toast=Toast.makeText(AddRecords.this,"Введіть всі дані",Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    ModelRecord record = new ModelRecord(etDate.getText().toString(),etName.getText().toString(),Integer.parseInt(etRecord.getText().toString()));
                    DBWorker dbWorker=new DBWorker(AddRecords.this);
                    dbWorker.addRecord(record);
                    dbWorker.close();
                    etDate.setText("");
                    etName.setText("");
                    etRecord.setText("");
                    Toast toast=Toast.makeText(AddRecords.this,"Запис додано",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddRecords.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
