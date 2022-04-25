package com.example.imagepro.game.tebakgambar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagepro.R;

import org.tensorflow.lite.support.metadata.schema.Content;

public class AdapterTg  extends RecyclerView.Adapter<AdapterTg.ViewHolder> {

    int image[];
    Context context;

    public AdapterTg(Context ct, int img[]){
        context = ct;
        image = img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_gambar, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.img_tg.setImageResource(image[position]);
        holder.btn_tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TebakGambar.class);
                intent.putExtra("image", image[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_tg;
        CardView btn_tg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_tg = itemView.findViewById(R.id.image_tg);
            btn_tg = itemView.findViewById(R.id.btn_tg);
        }
    }
}
