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


public class RestaurantList extends AppCompatActivity implements MyAdapter.OnListListener {
        private RecyclerView recyclerView;
        private ArrayList<Resturant> resturantList;
        DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_restaurant_list);
            recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
            resturantList = new ArrayList<Resturant>();

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Resturans");

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                        resturantList.add(dataSnapshot1.getValue(Resturant.class));



                    }
                    MyAdapter adapter = new MyAdapter(RestaurantList.this,resturantList,RestaurantList.this);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(RestaurantList.this,"Error",Toast.LENGTH_SHORT).show();
                }
            });


        }

    @Override
    public void OnListClick(int position) {
        Intent s = new Intent(getApplicationContext(), OrderPage.class);
        startActivity(s);
    }
}


