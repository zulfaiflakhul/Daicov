package com.example.imagepro.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.imagepro.R;
import com.example.imagepro.belajar.LearnGambar;
import com.example.imagepro.belajar.MenuLearn;
import com.example.imagepro.game.susunkata.MenuSusunKata;
import com.example.imagepro.game.susunkata.SusunKata;
import com.example.imagepro.game.tebakgambar.MenuTebakGambar;
import com.example.imagepro.game.tebakgambar.TebakGambar;
import com.example.imagepro.game.tebakhuruf.MenuTebakHuruf;
import com.example.imagepro.game.tebakhuruf.TebakHuruf;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        ImageButton tebakHuruf = findViewById(R.id.tebak_huruf);
        ImageButton tebakGambar = findViewById(R.id.tebak_gambar);
        ImageButton susunKata = findViewById(R.id.susun_kata);

        tebakHuruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(GameMenu.this, MenuTebakHuruf.class);
                startActivity(home);
                finish();

            }
        });

        tebakGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(GameMenu.this, MenuTebakGambar.class);
                startActivity(home);
                finish();
            }
        });

        susunKata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(GameMenu.this, MenuSusunKata.class);
                startActivity(home);
                finish();
            }
        });
    }
}