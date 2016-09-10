package com.turo.game2048;

import android.content.Context;
import android.util.AttributeSet;
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

    private void initGameView(){

    }
}
