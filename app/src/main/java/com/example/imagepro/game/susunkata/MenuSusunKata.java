package com.example.imagepro.game.susunkata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.imagepro.R;
import com.example.imagepro.belajar.LearnGambar;
import com.example.imagepro.belajar.MenuLearn;
import com.example.imagepro.game.GameMenu;
import com.example.imagepro.game.tebakhuruf.AdapterTh;

public class MenuSusunKata extends AppCompatActivity {

    String s1[];
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_susun_kata);

        s1 = getResources().getStringArray(R.array.susunkata);
        recyclerView = findViewById(R.id.rv_susunkata);

        AdapterSk adapterSk = new AdapterSk(this, s1);
        recyclerView.setAdapter(adapterSk);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent home = new Intent(MenuSusunKata.this, GameMenu.class);
        startActivity(home);
        finish();
    }
}