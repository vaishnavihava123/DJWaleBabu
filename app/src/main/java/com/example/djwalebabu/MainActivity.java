package com.example.djwalebabu;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnTouchListener, View.OnClickListener{
MediaPlayer mediaPlayer1,mediaPlayer2;
SoundPool soundPool;
Random random=new Random();
int dhamaka=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        View view=new View(this);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        setContentView(view);
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        dhamaka=soundPool.load(this,R.raw.explosion,1);
        mediaPlayer1=MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer2=MediaPlayer.create(this,R.raw.soundtrack);
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(286)));
       // mediaPlayer1.start();
        //mediaPlayer2.start();
    }


    @Override
    public boolean onLongClick(View view) {
        mediaPlayer2.start();
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(dhamaka!=0)
        {
            soundPool.play(dhamaka,1,1,0,0,1);
            view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(286)));
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        mediaPlayer1.start();

    }

    @Override
    protected void onPause() {
        mediaPlayer1.release();
        mediaPlayer2.release();
        super.onPause();
    }
}
