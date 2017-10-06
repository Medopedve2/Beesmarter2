package com.example.dikvsladik.beesmarter2.entity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.dikvsladik.beesmarter2.Game;

/**
 * Created by Dikvsladik on 2017. 04. 28..
 */

public class Flower extends Entity {
    Paint paint = new Paint();



    public Flower(float x, float y) {
        super(x, y);
        paint.setColor(Color.RED);
        r = 130;

    }

    public void collison(Entity other) {



    }


    @Override
    public void update() {



    }

    @Override
    public void render(Canvas canvas) {
             Game.flower.draw(canvas, new Rect((int) (x-r), (int)( y-r), (int) (x + r), (int) (y + r)), paint);

    }
}
