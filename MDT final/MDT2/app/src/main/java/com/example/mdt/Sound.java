package com.example.mdt;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;




public class Sound extends AppCompatActivity {

    private SeekBar seekBar;
    private AudioManager audioManager;
    private Button button,song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        seekBar=findViewById(R.id.seekBar);
        song=findViewById(R.id.song);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.heyram);
        Intent intent =new Intent(this,MyService.class);
        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                startService(intent);
            }
        });
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));


    }
    @Override protected void onPause()
    { // TODO Auto-generated method

        super.onPause();
    }
    @Override public boolean
    onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar
       // if {
            getMenuInflater().inflate(R.menu.activity_sound, menu);
        return true;
    }









    public void upButton(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this, "Volume up", Toast.LENGTH_SHORT).show();

    }
    public void downButton(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this, "Volume Down", Toast.LENGTH_SHORT).show();

    }





}