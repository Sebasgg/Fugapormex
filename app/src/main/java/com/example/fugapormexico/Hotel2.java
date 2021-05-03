package com.example.fugapormexico;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Hotel2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hoteldos );
        WebView myWebView = (WebView) findViewById(R.id.webview2);
        myWebView.loadUrl("https://nesttulum.com/es/");
    }
}
