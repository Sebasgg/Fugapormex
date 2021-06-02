package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Hotel5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hotelcinco );
        WebView myWebView = (WebView) findViewById(R.id.webview5);
        myWebView.loadUrl("https://www.guestreservations.com/holiday-inn-suites-aguascalientes/booking?gclid=EAIaIQobChMIzsWuo4zw8AIV8R6tBh2Zwwc1EAAYASAAEgJSCfD_BwE");
    }
}
