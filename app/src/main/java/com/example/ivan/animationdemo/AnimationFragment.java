package com.example.ivan.animationdemo;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class AnimationFragment extends DialogFragment {
    private GestureDetector gesture;
    
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_animation, container, false);
        gesture = new GestureDetector(getActivity(), new MyGestureListener());
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gesture.onTouchEvent(event);
                return true;
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }




    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (e1.getY() - e2.getY() > SWIPE_MAX_OFF_PATH  && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY){
                   getDialog().dismiss();
                    return true;
                }
                if (Math.abs(e1.getX() - e2.getX()) > SWIPE_MAX_OFF_PATH) {
                    return false;
                }

            } catch (Exception e) {

            }
            return false;
        }

    }


}
