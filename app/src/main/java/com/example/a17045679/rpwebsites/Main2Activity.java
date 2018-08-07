package com.example.a17045679.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        web = findViewById(R.id.WebView);

        //Received the Intent from MainActivity
        Intent intentReceived = getIntent();
        int Category = intentReceived.getIntExtra("Category",0);
        int Site = intentReceived.getIntExtra("Site",0);










    }
}
