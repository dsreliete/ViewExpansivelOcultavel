package com.example.eliete.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;


public class MainActivity extends Activity {

    private CardExpansivel cardExpansivel;
    private FrameLayout buttonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cardExpansivel = (CardExpansivel) findViewById(R.id.card);
        buttonContainer = (FrameLayout) findViewById(R.id.button_container);
        cardExpansivel.setViews(buttonContainer);

    }





}
