package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Hotel4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hotelcuatro );
        WebView myWebView = (WebView) findViewById(R.id.webview4);
        myWebView.loadUrl("https://www.krystal-hotels.com.mx/");
    }
}