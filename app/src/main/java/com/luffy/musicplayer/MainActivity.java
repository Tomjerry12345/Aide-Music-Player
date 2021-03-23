package com.luffy.musicplayer;

import android.app.*;
import android.media.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.chibde.visualizer.*;
import android.graphics.*;

public class MainActivity extends Activity 
{
	MediaPlayer mediaPlayer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		final ImageView play = findViewById(R.id.btnPlay);
		
		musicPlayer();
		
		play.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View p1)
				{
					if (mediaPlayer.isPlaying()) {
						mediaPlayer.pause();
						play.setImageResource(R.drawable.baseline_pause_circle_outline_black_24dp);
					} else {
						mediaPlayer.start();
						play.setImageResource(R.drawable.baseline_play_circle_outline_black_24dp);
					}
				}
		});
		
    }
	
	public void musicPlayer() {

	  CircleBarVisualizer circleVisualizer = findViewById(R.id.visualizer);
	  mediaPlayer = MediaPlayer.create(this, R.raw.music);
		
      circleVisualizer.setColor(Color.parseColor("#000000"));
 
      circleVisualizer.setPlayer(mediaPlayer.getAudioSessionId());
		
		
		}
	
}
