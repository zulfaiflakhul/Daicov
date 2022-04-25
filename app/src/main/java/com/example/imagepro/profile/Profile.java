package com.example.imagepro.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.imagepro.R;
import com.example.imagepro.login.GlobalVar;
import com.example.imagepro.login.Login;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends Fragment {

    TextView name, nama, email;

    RelativeLayout logout;
    FirebaseAuth fAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        name = view.findViewById(R.id.tv_profile_nama);
        nama = view.findViewById(R.id.tv_detail_nama);
        email = view.findViewById(R.id.tv_detail_email);
        name.setText(GlobalVar.currentUser.getNama());
        nama.setText(GlobalVar.currentUser.getNama());
        email.setText(GlobalVar.currentUser.getEmail());

        fAuth = FirebaseAuth.getInstance();
        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(requireContext())
                        .setTitle("Keluar")
                        .setMessage("Keluar dari aplikasi Daicov?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                fAuth.signOut();
                                signOutUser();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });

        RelativeLayout about = view.findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), About.class));
            }
        });

        return view;
    }

    private void signOutUser() {
        Intent Login = new Intent(requireContext(), Login.class);
        Login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(Login);
    }
}