package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PaginaRes6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pagina_res6 );

        WebView myWebView = (WebView) findViewById(R.id.webres1);
        myWebView.loadUrl("https://lasgaoneras.com.mx/");
    }
}
