package com.example.imagepro.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.imagepro.MainActivity;
import com.example.imagepro.R;
import com.example.imagepro.login.GlobalVar;
import com.example.imagepro.login.Login;
import com.example.imagepro.login.Register;
import com.example.imagepro.login.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashScreeen extends AppCompatActivity {

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screeen);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null){
            int waktu_loading = 2000;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    FirebaseDatabase.getInstance().getReference("User")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    GlobalVar.currentUser = snapshot.getValue(User.class);
                                    Intent home = new Intent(SplashScreeen.this, MainActivity.class);
                                    startActivity(home);
                                    finish();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                }
            }, waktu_loading);
        } else {

            int waktu_loading = 2000;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //setelah loading maka akan langsung berpindah ke home activity
                    Intent home=new Intent(SplashScreeen.this, Login.class);
                    startActivity(home);
                    finish();

                }
            }, waktu_loading);
        }


    }
}