package com.example.imagepro.game.susunkata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagepro.R;

import org.tensorflow.lite.support.metadata.schema.Content;

public class AdapterSk  extends RecyclerView.Adapter<AdapterSk.ViewHolder> {

    String data1[];
    Context context;

    public AdapterSk(Context ct, String s1[]){
        context = ct;
        data1 = s1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_level_th, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tv_level.setText(data1[position]);
        holder.btn_levelTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SusunKata.class);
                intent.putExtra("data1", data1[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_level;
        CardView btn_levelTh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_level = itemView.findViewById(R.id.tv_level);
            btn_levelTh = itemView.findViewById(R.id.btn_level_th);
        }
    }
}
