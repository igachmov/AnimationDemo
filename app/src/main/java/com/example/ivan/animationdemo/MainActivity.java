package com.example.ivan.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button clickMe;
    private AnimationFragment animationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMe = (Button) findViewById(R.id.button_animation);
        animationFragment = new AnimationFragment();


        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationFragment.show(getSupportFragmentManager(),"fragment");
            }
        });

    }

}
