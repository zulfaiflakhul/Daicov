package com.example.imagepro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.example.imagepro.help.Help;
import com.example.imagepro.home.Home;
import com.example.imagepro.profile.Profile;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    ChipNavigationBar bottomnav;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnav = findViewById(R.id.bottomNav);

        if (savedInstanceState == null){
            bottomnav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            Home home = new Home();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, home)
                    .commit();
        }

        bottomnav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {

                Fragment fragment = null;
                switch (id){
                    case R.id.home:
                        fragment = new Home();
                        break;

                    case R.id.help:
                        fragment = new Help();
                        break;

                    case R.id.profile:
                        fragment = new Profile();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.d(TAG, "Eror");
                }
            }
        });
    }
}