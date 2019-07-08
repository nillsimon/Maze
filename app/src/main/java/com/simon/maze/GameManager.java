package com.simon.maze;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends GestureDetector.SimpleOnGestureListener {
    private List<Drawable> drawables = new ArrayList<>();
    private View view;
    private Player player;
    private Maze maze;
    public Rect rect = new Rect();
    public int size = 15;


    public GameManager(){
        maze = new Maze(size);
        player = new Player(maze.getStart(), size);

        drawables.add(maze);
        drawables.add(player);


    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int diffX, diffY;
        diffX = Math.round(e2.getX() - e1.getX());
        diffY = Math.round(e2.getY() - e1.getY());
        if(Math.abs(diffX) > Math.abs(diffY)){
            diffX = diffX > 0 ? 1 : -1;
            diffY = 0;
        }else {
            diffX = 0;
            diffY = diffY > 0 ? 1 : -1;

        }
        int stepX = player.getX();
        int stepY = player.getY();

        while (maze.canPlayerGoTo(stepX + diffX, stepY + diffY)) {
            stepX += diffX;
            stepY += diffY;
            if (diffX != 0) {
                if (maze.canPlayerGoTo(stepX, stepY + 1)
                        || maze.canPlayerGoTo(stepX, stepY - 1)) {
                    break;
                }
            }
            if(diffY != 0){
                if (maze.canPlayerGoTo(stepX + 1, stepY)
                        || maze.canPlayerGoTo(stepX - 1, stepY)) {
                    break;
                }
            }
        }
        player.goTo(stepX, stepY);

        view.invalidate();
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void draw(Canvas canvas) {
        for(Drawable drawableItem: drawables){
            drawableItem.draw(canvas, rect);
        }
    }
    public void setView(View view) { this.view = view;
    }
    public void setScreenSize(int width, int height) {
        size = Math.min(width, height);
        rect.set(
                (width - size) / 2,
                (height - size) / 2,
                (width + size) / 2,
                (height + size) / 2
        );

    }
}
