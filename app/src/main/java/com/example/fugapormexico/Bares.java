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

public class Bares extends AppCompatActivity {
    GridLayout mainGridddd ;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bares );

        regresar=(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent( Bares.this,DosActivity.class);
                startActivity(o );
            }
        });

        mainGridddd = (GridLayout) findViewById(R.id.mainGridddd);

        //Set Event
        setSingleEvent(mainGridddd);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGridddd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGridddd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGridddd.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor( Color.parseColor("#FF6F00"));
                        Toast.makeText(Bares.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Bares.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGridddd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGridddd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGridddd.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if ( finalI ==  0 )
                    {

                        Intent intent = new Intent(Bares.this, Bar1.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  1 )
                    {

                        Intent intent = new Intent(Bares.this, Bar2.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  2)
                    {

                        Intent intent = new Intent(Bares.this, Bar3.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  3)
                    {

                        Intent intent = new Intent(Bares.this, Bar4.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  4 )
                    {

                        Intent intent = new Intent(Bares.this, Bar5.class);
                        startActivity( intent );
                    }else
                    if ( finalI ==  5 )
                    {

                        Intent intent = new Intent(Bares .this, Bar6.class);
                        startActivity( intent );
                    }



                }
            });

        }}}