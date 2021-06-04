package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class Estacionamientos extends AppCompatActivity {

    GridLayout mainGridd ;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_estacionamientos);
        regresar=(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent( Estacionamientos.this,DosActivity.class);
                startActivity(o );
            }
        });

        mainGridd = (GridLayout) findViewById(R.id.mainGridd);

        //Set Event
        setSingleEvent(mainGridd);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGridd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGridd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGridd.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor( Color.parseColor("#FF6F00"));
                        Toast.makeText(Estacionamientos.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Estacionamientos.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGridd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGridd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGridd.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if ( finalI ==  0 )
                    {

                        Intent intent = new Intent(Estacionamientos.this, Estacionamiento1.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  1 )
                    {

                        Intent intent = new Intent(Estacionamientos.this, Estacionamiento2.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  2)
                    {

                        Intent intent = new Intent(Estacionamientos.this, Estacionamiento3.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  3)
                    {

                        Intent intent = new Intent(Estacionamientos.this, Estacionamiento4.class);
                        startActivity( intent );
                    }
                }
            });

        }}}