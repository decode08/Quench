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
    Button login;
    TextView signup;
    EditText username, password1;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.Submit);
        videoView = findViewById(R.id.video_view);
        username = findViewById(R.id.login_email);
        password1= findViewById(R.id.password_login);
         signup= findViewById(R.id.login_register);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.back_orange);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String password = password1.getText().toString();



                mAuth = FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {

                                   Intent intent = new Intent(MainActivity.this, user_home.class);
                                   startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                               }
                           }
                                });

                            }
                        });
//        if(mAuth.getCurrentUser()!=null)
//        {
//            Intent intent = new Intent(MainActivity.this, user_home.class);
//            startActivity(intent);
//        }


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, signup_user1.class);
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
