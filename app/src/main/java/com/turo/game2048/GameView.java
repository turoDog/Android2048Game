package com.turo.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

/**
 * Created by YQ950209 on 2016/9/10.
 */
public class GameView extends GridLayout {

    public GameView(Context context) {
        super(context);

        initGameView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initGameView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initGameView();
    }

    private void initGameView() {
        setOnTouchListener(new OnTouchListener() {

            private float startX, startY, offsetX, offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;

                    case MotionEvent.ACTION_UP:
                        offsetX = event.getX() - startX;
                        offsetY = event.getY() - startY;

                        if (Math.abs(offsetX) > Math.abs(offsetY)) {
                            if (offsetX < -5) {
                                slideLeft();
                            } else if (offsetX > 5) {
                                slideRight();
                            }
                        } else {
                            if (offsetY < -5) {
                                slideUp();
                            } else if (offsetY > 5) {
                                slideDown();
                            }
                        }
                        break;

                }
                return true;
            }
        });


    }

    private void slideLeft() {

    }

    private void slideRight() {
    }

    private void slideUp(){

    }

    private void slideDown() {

    }

}





