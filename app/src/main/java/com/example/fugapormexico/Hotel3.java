package com.example.fugapormexico;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Hotel3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hoteltres );
        WebView myWebView = (WebView) findViewById(R.id.webview3);
        myWebView.loadUrl("https://www.booking.com/hotel/mx/san-marcos-aguascalientes1.es.html");
    }
}
