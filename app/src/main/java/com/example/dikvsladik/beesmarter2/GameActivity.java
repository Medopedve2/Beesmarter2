package com.example.dikvsladik.beesmarter2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameactivity);

        mediaPlayer.start();


    }


    @Override
    public void onPause() {
            super.onPause();
            mediaPlayer.stop();
            mediaPlayer.release();

    }


}

