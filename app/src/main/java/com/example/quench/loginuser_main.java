package com.example.quench;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class loginuser_main extends AppCompatActivity {

    VideoView videoView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_user);

        videoView = findViewById(R.id.video_view);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.back_orange);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        button = findViewById(R.id.Submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginuser_main.this, loginpage_ngo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        videoView.resume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.suspend();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}