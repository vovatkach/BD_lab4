package com.roksagmail.bd_lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    TextView tvNotRecords;
    List<ModelRecord> records;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        recyclerView=(RecyclerView)findViewById(R.id.rvRecords);
        tvNotRecords=(TextView)findViewById(R.id.tvNotRec);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        records=new ArrayList<>();
        DBWorker dbWorker=new DBWorker(MainActivity.this);
        records=dbWorker.getRecords();
        dbWorker.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(records.isEmpty())
        {
          tvNotRecords.setVisibility(View.VISIBLE);
        }else {
            tvNotRecords.setVisibility(View.GONE);
            RVAdapter adapter = new RVAdapter(records);
            recyclerView.setAdapter(adapter);
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddRecords.class);
                startActivity(intent);
            }
        });
    }
}
