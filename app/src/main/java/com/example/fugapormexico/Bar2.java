package com.example.fugapormexico;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bar2 extends AppCompatActivity {
    private Button mapa;
    Button regresar, promociones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bardos );
        //boton regresar
        regresar=(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent( Bar2.this,Bares.class);//Bar2 es el java que toma ---- Bares es a donde quieres ir
                startActivity(o );

            }
        });

        // boton de la  lugar
        promociones=(Button)findViewById(R.id.promociones);
        promociones .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent( Bar2.this,Promociones.class);
                startActivity(o );
            }
        });

        Button mDialButton = (Button) findViewById(R.id.btn_dial);
        final EditText mPhoneNoEt = (EditText) findViewById(R.id.et_phone_no);

        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// cambiar número
                String phoneNo = "4491234567";
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(Bar2.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
