package com.example.ab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<order> orders;
    private OnListListener onListListener;

    public MyAdapter(Context c,ArrayList<order> res, OnListListener onListListener ){

        context = c;
        orders = res;
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

        holder.name.setText(orders.get(position).getId());
        //  Picasso.with(context).load(resturantImages.getUriImage()).fit().into(holder.image);
      /*  Glide.with(context)
                .load(resturantImages.getUriImage())
                .into(holder.image);*/
    }
    @Override
    //function to determine size of list
    public int getItemCount() {
        //we dont know what size but we get size from arraylist by function size()
        return orders.size();
    }
    //declear items
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView  name;
        OnListListener onListListener;


        public MyViewHolder(@NonNull View itemView, OnListListener onListListener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.ordertName);
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

