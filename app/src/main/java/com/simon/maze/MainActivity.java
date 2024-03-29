package com.simon.maze;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MazeView view;
    private GestureDetector gestureDetector;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  String title = savedInstanceState.getString("Title");
       // Log.i(MainActivity.class.getName(), title);


        GameManager gameManager = new GameManager();
        view = new MazeView(this, gameManager);
        setContentView(view);

        gestureDetector = new GestureDetector(this, gameManager);
    }

    /*@Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("Title","Hello Word");
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }
}
