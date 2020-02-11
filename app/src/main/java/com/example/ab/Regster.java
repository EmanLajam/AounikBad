package com.example.ab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Regster extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;
    // DatabaseReference university;
    EditText edtUsername, edtPassword, edtMail , editID ,ediphon;
    Button btnSignUp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regster);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.editpassword);
        edtMail = (EditText)findViewById(R.id.ediEmail);
        editID = (EditText)findViewById(R.id.editID);
        ediphon = (EditText) findViewById(R.id.editPhone);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
       /* btnToSignIn = (Button) findViewById(R.id.btnToSingIn);




         btnToSignIn.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
        Intent s = new Intent(getApplicationContext(),LoginActivity.class);
           startActivity(s);
          }
         });
*/
btnSignUp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       final User user = new User(edtUsername.getText().toString(),
               edtPassword.getText().toString(),edtMail.getText().toString(),editID.getText().toString(),ediphon.getText().toString());

       users.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if(dataSnapshot.child(user.getID()).exists())
                  Toast.makeText(Regster.this,"the user exist",Toast.LENGTH_SHORT).show();
              else {
                  users.child(user.getID()).setValue(user);
                  Toast.makeText(Regster.this,"successfully registered",Toast.LENGTH_SHORT).show();
              }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }
});



    }
}
