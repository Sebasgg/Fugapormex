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
        myWebView.loadUrl("https://www.tripadvisor.com.mx/Hotel_Review-g659634-d573842-Reviews-Club_Drago_Park_Hotel-Costa_Calma_Pajara_Jandia_Peninsula_Fuerteventura_Canary_Islands.html");
    }
}
