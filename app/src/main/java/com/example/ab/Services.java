package com.example.ab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity {
    private Button ResturantBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        ResturantBtn = (Button) findViewById(R.id.coffe);

        ResturantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            /*    Intent ResturantList = new Intent(getApplicationContext(), OrderList.class);
                startActivity(ResturantList);*/
            }
        });
    }

}
