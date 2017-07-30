package com.example.ivan.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button clickMe;
    private AnimationFragment animationFragment;
    private GestureDetector gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMe = (Button) findViewById(R.id.button_animation);
        animationFragment = new AnimationFragment();
        gesture = new GestureDetector(this, new MyGestureListener());

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMe.setVisibility(View.INVISIBLE);
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in_top,
                                R.anim.slide_out_bottom)
                        .replace(R.id.fragment_container,animationFragment)
                        .commit();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gesture.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            clickMe.setVisibility(View.VISIBLE);
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_bottom,
                            R.anim.slide_out_top)
                    .remove(animationFragment)
                    .commit();
            return true;
        }
    }

}
