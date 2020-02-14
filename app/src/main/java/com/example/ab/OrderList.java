package com.example.ab;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;


<<<<<<< HEAD:app/src/main/java/com/example/ab/RestaurantList.java
public class RestaurantList extends AppCompatActivity implements MyAdapter.OnListListener {
    // رسايكل اللي انشائنها في اللي اوت
    //
=======
public class OrderList extends AppCompatActivity implements MyAdapter.OnListListener {
>>>>>>> 9928273063501e86fab00fad1ed3c48ae56ed621:app/src/main/java/com/example/ab/OrderList.java
        private RecyclerView recyclerView;
        private ArrayList<order> orders;
        DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_list);
            recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
            orders = new ArrayList<order>();

            recyclerView.setHasFixedSize(true);
            // تربط الادوات وتظره البيانات فيها الصورة و الكلام
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Order");

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                        orders.add(dataSnapshot1.getValue(order.class));



                    }
<<<<<<< HEAD:app/src/main/java/com/example/ab/RestaurantList.java
                    // الادابرت وظيفاتها انها توفر العناصر اللي يحتاجتجها اليوز
                    MyAdapter adapter = new MyAdapter(RestaurantList.this,resturantList,RestaurantList.this);
=======
                    MyAdapter adapter = new MyAdapter(OrderList.this, orders, OrderList.this);
>>>>>>> 9928273063501e86fab00fad1ed3c48ae56ed621:app/src/main/java/com/example/ab/OrderList.java
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(OrderList.this,"Error",Toast.LENGTH_SHORT).show();
                }
            });


        }

    @Override
    public void OnListClick(int position) {
        Intent s = new Intent(getApplicationContext(), OrderForm.class);
        startActivity(s);
    }
}


