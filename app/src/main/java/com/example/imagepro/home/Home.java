package com.example.imagepro.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagepro.belajar.LearnGambar;
import com.example.imagepro.belajar.MenuLearn;
import com.example.imagepro.game.GameMenu;
import com.example.imagepro.penerjemah.CameraActivity;
import com.example.imagepro.R;
import com.example.imagepro.login.GlobalVar;
import com.example.imagepro.profile.Profile;

import org.opencv.android.OpenCVLoader;

public class Home extends Fragment {

    TextView name, email;

    public Home(){

    }

    static {
        if(OpenCVLoader.initDebug()){
            Log.d("Home: ","Opencv is loaded");
        }
        else {
            Log.d("Home: ","Opencv failed to load");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        name = view.findViewById(R.id.tv_nama);
        email = view.findViewById(R.id.tv_email);
        name.setText(GlobalVar.currentUser.getNama());
        email.setText(GlobalVar.currentUser.getEmail());

        ImageButton liveTranslate = view.findViewById(R.id.btn_live_translate);
        liveTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        ImageButton game = view.findViewById(R.id.btn_games);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(requireContext(), GameMenu.class);
                startActivity(home);

            }
        });

        ImageButton learn = view.findViewById(R.id.btn_learn);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(requireContext(), MenuLearn.class);
                startActivity(home);

            }
        });

        ImageView profile = view.findViewById(R.id.avatar_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Profile profile = new Profile();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, profile).commit();
            }
        });

        return view;
    }

}