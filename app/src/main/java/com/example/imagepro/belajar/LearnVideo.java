package com.example.imagepro.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.imagepro.R;

public class LearnVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_video);

        VideoView videoView = findViewById(R.id.video_learn);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_sl;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent home = new Intent(LearnVideo.this, MenuLearn.class);
        startActivity(home);
        finish();
    }
}