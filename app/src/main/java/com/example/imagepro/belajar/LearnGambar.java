package com.example.imagepro.belajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.imagepro.R;
import com.example.imagepro.belajar.AdapterLg;
import com.example.imagepro.game.GameMenu;
import com.example.imagepro.game.susunkata.MenuSusunKata;
import com.example.imagepro.game.tebakhuruf.AdapterTh;

public class LearnGambar extends AppCompatActivity {

    RecyclerView recyclerView;
    int image[] = {R.drawable.ls_satu, R.drawable.ls_dua, R.drawable.ls_tiga, R.drawable.ls_empat, R.drawable.ls_lima,
            R.drawable.ls_enam, R.drawable.ls_tujuh, R.drawable.ls_delapan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_gambar);

        recyclerView = findViewById(R.id.rv_learngambar);
        AdapterLg adapterLg = new AdapterLg(this, image);
        recyclerView.setAdapter(adapterLg);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent home = new Intent(LearnGambar.this, MenuLearn.class);
        startActivity(home);
        finish();
    }

}