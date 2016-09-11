package com.turo.game2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvScore;
    private static MainActivity mainActivity;
    private int score = 0;

    public MainActivity(){
        mainActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScore = (TextView) findViewById(R.id.tvscore);
    }

    public void clearScore (){
        score = 0;
        showScore();
    }

    private void showScore() {
        tvScore.setText(score+"");
    }

    public void addScore(int s){
        score+=s;
        showScore();
    }

    public static MainActivity getMainActivity(){
        return mainActivity;
    }
}
