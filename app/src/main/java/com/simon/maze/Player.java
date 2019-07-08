package com.simon.maze;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

public class Player implements Drawable {
    private Point point;
    private Paint paint;
    private int size;

    public Player(Point start, int size) {
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setColor(Color.RED);
    point = start;
    this.size = size;
    }
public void goTo(int x, int y){
        point.x = x;
        point.y = y;
    Log.i("Player",String.format("%d %d", point.x, point.y));

}
public int getX(){
        return point.x;
}

public int getY(){
        return point.y;
}
    @Override
    public void draw(Canvas canvas, Rect rect) {
        float cellSize = (float)(rect.right - rect.left) / size;
        canvas.drawRect(
                rect.left + point.x * cellSize,
                rect.top + point.y * cellSize,
                rect.left + point.x * cellSize + cellSize,
                rect.top + point.y * cellSize + cellSize,
                paint
        );
    }
}
