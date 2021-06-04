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

public class Hoteles extends AppCompatActivity {
    GridLayout mainGriddd ;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hoteles);

        regresar=(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent( Hoteles.this,DosActivity.class);
                startActivity(o );
            }
        });

        mainGriddd = (GridLayout) findViewById(R.id.mainGriddd);

        //Set Event
        setSingleEvent(mainGriddd);
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
                        Toast.makeText(Hoteles.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Hoteles.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGriddd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGriddd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGriddd.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if ( finalI ==  0 )
                    {

                        Intent intent = new Intent(Hoteles.this, Hotel1.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  1 )
                    {

                        Intent intent = new Intent(Hoteles.this, Hotel2.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  2)
                    {

                        Intent intent = new Intent(Hoteles.this, Hotel3.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  3)
                    {

                        Intent intent = new Intent(Hoteles.this, Hotel4.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  4 )
                    {

                        Intent intent = new Intent(Hoteles.this, Hotel5.class);
                        startActivity( intent );
                    }else
                    if ( finalI ==  5 )
                    {

                        Intent intent = new Intent(Hoteles.this, Hotel6.class);
                        startActivity( intent );
                    }



                }
            });

        }}}