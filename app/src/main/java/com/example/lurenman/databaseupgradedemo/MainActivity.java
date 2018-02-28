package com.example.lurenman.databaseupgradedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lurenman.databaseupgradedemo.activity.SqliteActivity;

public class MainActivity extends AppCompatActivity {

    private Button bt_sqlite;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initViews();
        initEvents();
        //DataUtils.initVersionTwoDatas();
        //DataUtils.initVersionFiveDatas();
    }

    private void initViews() {
        bt_sqlite = (Button) findViewById(R.id.bt_sqlite);
    }

    private void initEvents() {
        bt_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SqliteActivity.class);
                startActivity(intent);
            }
        });
    }
}
