package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class Restaurantes extends AppCompatActivity {
    GridLayout mainRestaurantes ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_restaurantes );

        mainRestaurantes = (GridLayout) findViewById(R.id.mainRestaurantes);

        //Set Event
        setSingleEvent(mainRestaurantes);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainRestaurantes) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainRestaurantes.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainRestaurantes.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor( Color.parseColor("#FF6F00"));
                        Toast.makeText(Restaurantes.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Restaurantes.this, "State : False", Toast.LENGTH_SHORT).show();
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

                        Intent intent = new Intent(Restaurantes.this, Restaurante1.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  1 )
                    {

                        Intent intent = new Intent(Restaurantes.this, Restaurante1.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  2)
                    {

                        Intent intent = new Intent(Restaurantes.this, Restaurante3.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  3)
                    {

                        Intent intent = new Intent(Restaurantes.this, Restaurante4.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  4 )
                    {

                        Intent intent = new Intent(Restaurantes.this, Restaurante5.class);
                        startActivity( intent );
                    }else
                    if ( finalI ==  5 )
                    {

                        Intent intent = new Intent(Restaurantes.this, Restaurante6.class);
                        startActivity( intent );
                    }
                }
            });
        }}}