package com.example.hp.mockipl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HP on 3/24/2017.
 */

public class Result extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent ires=getIntent();
        int i=ires.getIntExtra("Score",0);
        String str=Integer.toString(i);
        TextView tres=(TextView)findViewById(R.id.text_res);
        tres.setText(str);///*
        /*
        SharedPreferences sh=getBaseContext().getSharedPreferences("MyPef",Context.MODE_PRIVATE);
        int s=sh.getInt("")*/
    }
}
