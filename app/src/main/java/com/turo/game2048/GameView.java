package com.turo.game2048;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

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
        setColumnCount(4);      //游戏界面一共四列
        setBackgroundColor(0xffbbada0);  //游戏背景颜色
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

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int cardWidth = (Math.min(w, h)-10)/4;  //求屏幕宽高的最小值，分割出每块卡片的宽度

        addCards(cardWidth,cardWidth);          //添加卡片方法

        startGame();

    }

    private void addCards(int cardWidth, int cardHeight){
        Card c;
        for (int y = 0; y < 4; y++){
            for (int x =0; x < 4; x++ ){
                c = new Card(getContext());
                c.setNum(0);
                addView(c, cardWidth, cardHeight);//添加16个卡片到GameView中

                cardMap[x][y] = c;
            }
        }

    }

    private void startGame(){
        for (int y = 0; y < 4; y++){
            for (int x=0; x<4; x++){
                cardMap[x][y].setNum(0);
            }
        }

        addRandomNum();
        addRandomNum();
    }

    private void addRandomNum (){
        emptyPoints.clear();
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 4; x++){
                if (cardMap[x][y].getNum()<=0){
                    emptyPoints.add(new Point(x,y));
                }
            }
        }
        Point p = emptyPoints.remove((int) ((Math.random()*emptyPoints.size())));
        cardMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
    }

    private void slideLeft() {

    }

    private void slideRight() {
    }

    private void slideUp(){

    }

    private void slideDown() {

    }

    private Card[][] cardMap = new Card[4][4];
    private List<Point> emptyPoints = new ArrayList<Point>();

}





