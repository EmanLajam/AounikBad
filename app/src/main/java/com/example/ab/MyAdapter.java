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
    // راح تربط كل اوبجكت في الاري  في الليست ايتم
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
    // توفر الوصل الى كل الفيوز
    // تستعدي الكيست الايتم وتربطه مع اللهولدر
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false),onListListener);

    }

    @Override
    //here we control with items
    // نمرر القيم جو الفيوز و استناد القيم الموجوه داله الليست ايتم
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
<<<<<<< HEAD
        // العنصر الحالي في الموقع الحالي صار في الكرند
        Resturant resturantImages = resturants.get(position);
        // تمرير القيم
        holder.name.setText(resturants.get(position).getNameOFResturant());
        //  Picasso.with(context).load(resturantImages.getUriImage()).fit().into(holder.image);
        // العنصر الحالي في الاير راح يجيب قيمه الفيو و هذا القيم سوف يسند القيم و يربطخ مع الفيو هولدر
        Glide.with(context)
=======

        holder.name.setText(orders.get(position).getId());
        //  Picasso.with(context).load(resturantImages.getUriImage()).fit().into(holder.image);
      /*  Glide.with(context)
>>>>>>> 9928273063501e86fab00fad1ed3c48ae56ed621
                .load(resturantImages.getUriImage())
                .into(holder.image);*/
    }
    @Override
    // عدد الايتم اللموجوده بالرسايكل فيو
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

