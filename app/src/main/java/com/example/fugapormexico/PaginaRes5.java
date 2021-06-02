package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PaginaRes5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pagina_res5 );

        WebView myWebView = (WebView) findViewById(R.id.webres1);
        myWebView.loadUrl("https://www.facebook.com/Puerta-Grande-Restaurante-176851399162884/");
    }
}