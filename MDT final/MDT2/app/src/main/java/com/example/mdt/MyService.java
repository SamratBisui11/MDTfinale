package com.example.mdt;
import java.io.IOException;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class MyService extends Service {
        MediaPlayer media;
        @Override
        public IBinder onBind(Intent intent) {
// TODO Auto-generated method stub
            return null; }
        @Override public void onCreate() {
// TODO Auto-generated method stub
            super.onCreate();
        }
        @Override public int onStartCommand(Intent
                                                    intent, int flags, int startId) {
            media=MediaPlayer.create(this, R.raw.heyram);
            try { media.prepare();
            } catch (IllegalStateException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            media.start();
            // TODO Auto-generated method stub
            return super.onStartCommand(intent, flags,
                    startId);
        }
        @Override public void onDestroy() {
// TODO Auto-generated method stub
            media.release(); super.onDestroy();
        } }

