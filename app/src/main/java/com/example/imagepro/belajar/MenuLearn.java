package com.example.imagepro.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imagepro.MainActivity;
import com.example.imagepro.R;
import com.example.imagepro.login.GlobalVar;
import com.example.imagepro.login.Login;
import com.example.imagepro.penerjemah.CameraActivity;

public class MenuLearn extends AppCompatActivity {

    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_learn);

        name = findViewById(R.id.tv_learn_nama);
        email = findViewById(R.id.tv_learn_email);
        name.setText(GlobalVar.currentUser.getNama());
        email.setText(GlobalVar.currentUser.getEmail());

        ImageButton btn_learnGambar = findViewById(R.id.btn_learn_gambar);
        btn_learnGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MenuLearn.this, LearnGambar.class);
                startActivity(home);
                finish();
            }
        });

        ImageButton btn_learnVIdeo = findViewById(R.id.btn_learn_video);
        btn_learnVIdeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MenuLearn.this, LearnVideo.class);
                startActivity(home);
                finish();
            }
        });
    }
}