package com.example.ab;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Resturant> resturants;
    private OnListListener onListListener;

    public MyAdapter(Context c,ArrayList<Resturant> res, OnListListener onListListener ){

        context = c;
        resturants = res;
        this.onListListener = onListListener;
    }
    @NonNull
    @Override
    //THIS fanction determines the page design we will implement the list
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false),onListListener);

    }

    @Override
    //here we control with items
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Resturant resturantImages = resturants.get(position);
        holder.name.setText(resturants.get(position).getNameOFResturant());
        //  Picasso.with(context).load(resturantImages.getUriImage()).fit().into(holder.image);
        Glide.with(context)
                .load(resturantImages.getUriImage())
                .into(holder.image);
    }
    @Override
    //function to determine size of list
    public int getItemCount() {
        //we dont know what size but we get size from arraylist by function size()
        return resturants.size();
    }
    //declear items
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView  name;
        ImageView image;
        OnListListener onListListener;


        public MyViewHolder(@NonNull View itemView, OnListListener onListListener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.resturantName);
            image = (ImageView) itemView.findViewById(R.id.imageView8);
            this.onListListener = onListListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListListener.OnListClick(getAdapterPosition());
        }
    }
        public interface OnListListener{
            void OnListClick(int position);

        }
    }

