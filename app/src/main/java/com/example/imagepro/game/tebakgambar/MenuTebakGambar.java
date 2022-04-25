package com.example.imagepro.game.tebakgambar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.imagepro.R;
import com.example.imagepro.game.GameMenu;
import com.example.imagepro.game.susunkata.MenuSusunKata;
import com.example.imagepro.game.tebakhuruf.AdapterTh;

public class MenuTebakGambar extends AppCompatActivity {

    RecyclerView recyclerView;
    int image[] = {R.drawable.kucing, R.drawable.aning, R.drawable.lebah, R.drawable.macan, R.drawable.monyet,
    R.drawable.bebek, R.drawable.jerapah, R.drawable.sapi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tebak_gambar);

        recyclerView = findViewById(R.id.rv_tebakgambar);
        AdapterTg adapterTg = new AdapterTg(this, image);
        recyclerView.setAdapter(adapterTg);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent home = new Intent(MenuTebakGambar.this, GameMenu.class);
        startActivity(home);
        finish();
    }
}