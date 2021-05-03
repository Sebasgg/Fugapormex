package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Hotel1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hoteluno );

        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://www.betulum.com/?gclid=EAIaIQobChMI1ZOfuq6-6QIVR__jBx0HkwAbEAAYASAAEgLDHPD_BwE");
    }
}
