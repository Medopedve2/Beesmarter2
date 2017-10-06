package com.example.dikvsladik.beesmarter2.entity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.dikvsladik.beesmarter2.Game;

/**
 * Created by Dikvsladik on 2017. 04. 28..
 */

public class Frog extends Entity {

    public float newX, newY;

    public int i =0 ;

    Paint paint = new Paint();

    public Frog(float x, float y) {
        super(x, y);
        r = 90;
        newX = x;
        newY = y;
        paint.setColor(Color.GREEN);
    }

    @Override
    public void collison(Entity other) {

    }
        @Override
        public void update () {
             i+=1;

            if (i > 60){
                float dx = newX - x;
                float dy = newY - y;
                x += dx / 45;
                y += dy / 45;
            }else {
                x += 0;
                y += 0;
            }

           if(i==120){
               i=0;
           }
        }

    @Override
    public void render(Canvas canvas) {
        Game.frgoy.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
