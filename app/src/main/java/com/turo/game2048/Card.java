package com.turo.game2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by YQ950209 on 2016/9/10.
 */
public class Card extends FrameLayout{

    public Card(Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(32);      //卡片字体大小
        label.setBackgroundColor(0x33ffffff);//卡片背景颜色
        label.setGravity(Gravity.CENTER);   //游戏主界面位于屏幕正中间

        LayoutParams lp = new LayoutParams(-1,-1);  //填充满整个父级容器
        lp.setMargins(10, 10, 0, 0);        //每个卡片之间的间隔
        addView(label, lp);

        setNum(0);
    }

    private int num = 0;

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;

        if (num<=0) {
            label.setText("");
        }else{
            label.setText(num+"");
        }
    }

    public boolean equals(Card o) {
        return getNum() == o.getNum();
    }

    private TextView label;
}
