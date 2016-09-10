package com.turo.game2048;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by YQ950209 on 2016/9/10.
 */
public class Card extends FrameLayout{

    public Card(Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(32);

        LayoutParams lp = new LayoutParams(-1,-1);
        addView(label, lp);

        setNum(0);
    }

    private int num = 0;

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;


        label.setText(num + "");
    }

    public boolean equals(Card o) {
        return getNum() == o.getNum();
    }

    private TextView label;
}
