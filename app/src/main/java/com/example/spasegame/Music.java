package com.example.spasegame;

import android.app.Activity;
import android.media.MediaPlayer;

public class Music  {
    private MediaPlayer gamesound;
    Activity activity;
    public Music(Activity activity){
        this.activity=activity;
        gamesound = MediaPlayer.create(activity,R.raw.soundtheme);
    }
    public void playmusic(){
        gamesound.start();
    }

}
