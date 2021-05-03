package com.example.fugapormexico;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splash extends Activity {
    private final int DURACION_SPLASE = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView( R.layout.activity_splash  );
        new Handler(  ).postDelayed(new Runnable() {
            public void run (){
                Intent intent=new Intent(Splash.this,Inicio.class);
                startActivity( intent );
                finish();
            };
        },DURACION_SPLASE);
    }
}