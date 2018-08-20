package com.principa.subnetting.easy.Units;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.principa.subnetting.easy.R;
import com.principa.subnetting.easy.Theory.TheoryTwo;

public class UnitTwo extends AppCompatActivity {

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private ImageView ivAlpha;
    private Button btnTheo;

    private Animation animacion;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_two);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        ivAlpha = (ImageView) findViewById(R.id.ivAlpha);
        btnTheo = (Button)findViewById(R.id.btnTheo);

        btnTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitTwo.this, TheoryTwo.class);
                startActivity(intent);
            }
        });

        animacion = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.blink_photo);
        initUI();
        initMediaPlayer();
    }

    public void initUI() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    public void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(
                getApplicationContext(), R.raw.unit2);

    }

    public void play(View view) {
        try {
            mediaPlayer.start();
            ivAlpha.startAnimation(animacion);
            btnPause.setEnabled(true);
            btnStop.setEnabled(true);
            btnPlay.setEnabled(false);
        } catch (IllegalStateException e){
            Log.i("MediaPlayer", "Error: "+e.getMessage());
        }
    }


    public void pause(View view) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            ivAlpha.clearAnimation();
            btnPlay.setEnabled(true);
            btnStop.setEnabled(false);
        }
    }
    public void stop(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            initMediaPlayer();
            ivAlpha.clearAnimation();
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
        }
    }

}
