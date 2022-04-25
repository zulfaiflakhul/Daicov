package com.example.imagepro.game.tebakhuruf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.imagepro.R;
import com.example.imagepro.game.GameMenu;
import com.example.imagepro.game.susunkata.MenuSusunKata;

public class MenuTebakHuruf extends AppCompatActivity {

    String s1[];
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tebak_huruf);

        s1 = getResources().getStringArray(R.array.game_level);
        recyclerView = findViewById(R.id.rv_tebakhuruf);

        AdapterTh adapterTh = new AdapterTh(this, s1);
        recyclerView.setAdapter(adapterTh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent home = new Intent(MenuTebakHuruf.this, GameMenu.class);
        startActivity(home);
        finish();
    }
}