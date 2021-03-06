package com.example.dikvsladik.beesmarter2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.example.dikvsladik.beesmarter2.entity.Entity;
import com.example.dikvsladik.beesmarter2.entity.Flower;
import com.example.dikvsladik.beesmarter2.entity.Frog;
import com.example.dikvsladik.beesmarter2.entity.Player;
import com.example.dikvsladik.beesmarter2.utils.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dikvsladik on 2017. 04. 21..
 */

public class Game extends Thread{

    public static Game game;
    public final String TAG = Game.class.getSimpleName();
    private final Context context;
    public int width;
    public int height;

    SurfaceHolder surfaceHolder;
    Player player;
    Frog beka;
    Settings settings;

    public  static Sprite grass;
    public  static Sprite flower;
    public  static Sprite bee1;
    public  static Sprite bee2;
    public  static Sprite bee3;
    public  static Sprite bee4;
    public  static Sprite frgoy;

    Random rnd = new Random();
    List<Entity> objects = new ArrayList<>();
    Paint paint = new Paint();


    public Game(Context context, SurfaceHolder surfaceHolder) {

        this.surfaceHolder = surfaceHolder;
        game = this;
        this.context =context;
        paint.setColor(Color.BLUE);
        settings = new Settings();
    }

    @Override
    public void run() {
        super.run();
        init();
        Resources res = context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.grass);

        while (true) {


            Canvas canvas = surfaceHolder.lockCanvas();

            if (canvas != null) {
                canvas.drawPaint(paint);
                paint.setColor(Color.YELLOW);
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                paint.setTextSize(100);
                canvas.drawBitmap(bitmap,0,0,null);

                render(canvas);
                update();
                canvas.drawText(String.valueOf("Score: "+player.pont), 10, 100, paint);


                surfaceHolder.unlockCanvasAndPost(canvas);
            }


            try {
                sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void render(Canvas canvas) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(canvas);

        }


    }




    private void update() {



        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update();
            beka.newX=player.getX();
            beka.newY=player.getY();

        }
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                Entity e1 = objects.get(i);
                Entity e2 = objects.get(j);
                if (e1.isColliding(e2)) {
                    e2.collison(e1);
                    e1.collison(e2);

                }


            }
        }

        for (int i = 0; i < objects.size(); i++) {
            Entity entity = objects.get(i);



            if (entity.getY() > height + 2 * entity.getR() || entity.isDead()) {
                objects.remove(i);

            }
            if (entity.getY()<0-2*entity.getR()) {
                objects.remove(i);}
            if (entity.endgame()){
                changeActivitytogamover();

            }
            if (entity.ujvirag()){
                Entity virag = new Flower(rnd.nextInt(width ), rnd.nextInt(height));
                addEntity(virag);

                entity.uj=false;
            }


        }

    }

    void init() {
        // create player obj
        player = new Player(width / 2, height / 2);
        objects.add(player);
        Entity virag = new Flower(rnd.nextInt(width ), rnd.nextInt(height));
        addEntity(virag);
        beka = new Frog(width/2,height);
        objects.add(beka);

        if (settings.hanyasbee==4){
            bee1 = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.bee));
        }
        if (settings.hanyasbee==2){
            bee1 = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.beeorange));
        }
        if (settings.hanyasbee==3){
            bee1 = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.beegreen));
        }
        if (settings.hanyasbee==1){
            bee1 = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.beeblue));
        }
        grass= new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.grass));
        flower = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.flower));
        frgoy = new Sprite(BitmapFactory.decodeResource(context.getResources(), R.drawable.frog));

    }

    public void addEntity(Entity e) {
        objects.add(e);

    }


    public boolean onTouch(MotionEvent event) {
        Log.v(TAG, event.toString());
        if (event.getAction() == MotionEvent.ACTION_MOVE ||
                event.getAction() == MotionEvent.ACTION_DOWN ||
                event.getAction() == MotionEvent.ACTION_POINTER_DOWN) {

            player.newX = event.getX();
            player.newY = event.getY();


            return true;
        }
        return false;
    }
    public void changeActivitytogamover(){
        Intent intent = new Intent(context, GameOver.class);
        context.startActivity(intent);

    }


}
