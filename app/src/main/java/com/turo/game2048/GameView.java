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

        //每次启动游戏清理卡片中的数字
        for (int y = 0; y < 4; y++){
            for (int x=0; x<4; x++){
                cardMap[x][y].setNum(0);
            }
        }

        addRandomNum();
        addRandomNum();
        addRandomNum();
        addRandomNum();
        addRandomNum();
        addRandomNum();
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
        //每次循环结束随机取出一个点，并将其中2,4按9:1的比例随机显示在卡片中
        Point p = emptyPoints.remove((int) ((Math.random()*emptyPoints.size())));
        cardMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
    }

    private void slideLeft() {
        for(int y =0; y<4; y++){
            for (int x=0; x<4; x++){

                for (int x1 =x+1; x1<4; x1++){

                    if (cardMap[x1][y].getNum() > 0) {
                        if (cardMap[x][y].getNum() <= 0) {
                            cardMap[x][y].setNum(cardMap[x1][y].getNum());
                            cardMap[x1][y].setNum(0);
                            x--;
                            break;
                        } else if (cardMap[x][y].equals(cardMap[x1][y])) {
                            cardMap[x][y].setNum(cardMap[x][y].getNum() * 2);
                            cardMap[x1][y].setNum(0);
                            break;
                        }
                    }
                }
            }
        }

    }

    private void slideRight() {
        for(int y =0; y<4; y++){
            for (int x=3; x>=0; x--){

                for (int x1 =x-1; x1>=0; x1--){

                    if (cardMap[x1][y].getNum() > 0) {
                        if (cardMap[x][y].getNum() <= 0) {
                            cardMap[x][y].setNum(cardMap[x1][y].getNum());
                            cardMap[x1][y].setNum(0);
                            x++;
                            break;
                        } else if (cardMap[x][y].equals(cardMap[x1][y])) {
                            cardMap[x][y].setNum(cardMap[x][y].getNum() * 2);
                            cardMap[x1][y].setNum(0);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void slideUp(){
        for(int x =0; x<4; x++){
            for (int y=0; y<4; y++){

                for (int y1 =y+1; y1<4; y1++){

                    if (cardMap[x][y1].getNum() > 0) {
                        if (cardMap[x][y].getNum() <= 0) {
                            cardMap[x][y].setNum(cardMap[x][y1].getNum());
                            cardMap[x][y1].setNum(0);
                            y--;
                            break;
                        } else if (cardMap[x][y].equals(cardMap[x][y1])) {
                            cardMap[x][y].setNum(cardMap[x][y].getNum() * 2);
                            cardMap[x][y1].setNum(0);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void slideDown() {
        for(int x =0; x<4; x++){
            for (int y=3; y>=0; y--){

                for (int y1 =y-1; y1>=0; y1--){

                    if (cardMap[x][y1].getNum() > 0) {
                        if (cardMap[x][y].getNum() <= 0) {
                            cardMap[x][y].setNum(cardMap[x][y1].getNum());
                            cardMap[x][y1].setNum(0);
                            y++;
                            break;
                        } else if (cardMap[x][y].equals(cardMap[x][y1])) {
                            cardMap[x][y].setNum(cardMap[x][y].getNum() * 2);
                            cardMap[x][y1].setNum(0);
                            break;
                        }
                    }
                }
            }
        }

    }

    private Card[][] cardMap = new Card[4][4];
    private List<Point> emptyPoints = new ArrayList<Point>();

}





