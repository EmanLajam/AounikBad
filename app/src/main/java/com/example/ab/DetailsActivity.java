package com.example.ab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent i = getIntent();
        String result = i.getStringExtra("name");
        Toast.makeText(DetailsActivity.this,result,Toast.LENGTH_LONG).show();

    }
}
