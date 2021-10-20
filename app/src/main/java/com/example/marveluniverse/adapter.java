package com.example.marveluniverse;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<additem> arrayList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample, parent, false);
        return new viewholder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof viewholder) {
            additem obj = arrayList.get(position);

            ((viewholder) holder).textView.setText(obj.getName());
            Picasso.get().load(obj.getImage()).placeholder(R.drawable.placeholder).into(((viewholder) holder).imageView);

        }
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
