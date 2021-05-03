package com.example.fugapormexico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class DosActivity extends AppCompatActivity {
    GridLayout mainGriop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos2);

        mainGriop = (GridLayout) findViewById(R.id.mainGriop);

        //Set Event
        setSingleEvent(mainGriop);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGriop) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGriop.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGriop.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor( Color.parseColor("#FF6F00"));
                        Toast.makeText( DosActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText( DosActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGriop) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGriop.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGriop.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if ( finalI ==  0 )
                    {

                        Intent intent = new Intent( DosActivity.this,Restaurantes.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  1 )
                    {

                        Intent intent = new Intent( DosActivity.this,Hoteles.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  2)
                    {

                        Intent intent = new Intent( DosActivity.this,Bares.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  3)
                    {

                        Intent intent = new Intent( DosActivity.this,Estacionamientos.class);
                        startActivity( intent );
                    }




                }
            });

        }}}