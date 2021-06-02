package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Hotel6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hotelseis );

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.hotelfranciaaguascalientes.com/es/");
    }
}
