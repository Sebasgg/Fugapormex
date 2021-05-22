package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bar2 extends AppCompatActivity {
    private Button mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bardos );
        mapa= (Button)findViewById( R.id.Mapa );
        mapa.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( Bar2.this, MapsActivity2.class );
                startActivity( intent );
            }
        } );

    }
}