package com.example.dikvsladik.beesmarter2;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Switch aSwitch;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;

    public int hanyasbee = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setX(600);
        aSwitch.setY(700);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton.setX(70);
        imageButton.setY(1240);
        imageButton2.setX(400);
        imageButton2.setY(1240);
        imageButton3.setX(750);
        imageButton3.setY(1240);
        imageButton4.setX(1080);
        imageButton4.setY(1240);
        imageButton5.setX(0 - 825);
        imageButton5.setY(1900);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    am.setStreamMute(AudioManager.STREAM_MUSIC, true);
                } else {
                    AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    am.setStreamMute(AudioManager.STREAM_MUSIC, false);
                }


            }

        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyasbee = 1;
                Toast.makeText(getBaseContext(), "ERROR: A funkció jelenleg nem elérhető.",
                        Toast.LENGTH_LONG).show();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyasbee = 2;
                Toast.makeText(getBaseContext(), "ERROR: A funkció jelenleg nem elérhető.",
                        Toast.LENGTH_LONG).show();
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyasbee = 3;
                Toast.makeText(getBaseContext(), "ERROR: A funkció jelenleg nem elérhető.",
                        Toast.LENGTH_LONG).show();
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyasbee = 4;
                Toast.makeText(getBaseContext(), "ERROR: A funkció jelenleg nem elérhető.",
                        Toast.LENGTH_LONG).show();
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Settings.this, GameStart.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }


    }
}

