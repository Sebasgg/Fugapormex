package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PaginaRes3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pagina_res3 );

        WebView myWebView = (WebView) findViewById(R.id.webres1);
        myWebView.loadUrl("https://restaurantlosarcos.com/aguascalientes/");
    }
}
