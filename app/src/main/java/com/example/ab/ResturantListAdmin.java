package com.example.ab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class ResturantListAdmin extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    StorageReference storageRefrence;
    EditText ResturantName;
    EditText latitude;
    EditText longitude;
    EditText image;
    Button addRes;
    Button add;
    Uri imageUri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_list_admin);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Resturans");
        storageRefrence = FirebaseStorage.getInstance().getReference("Image");
        ResturantName = (EditText) findViewById(R.id.ResturantName);
        latitude = (EditText) findViewById(R.id.latitudeID);
        longitude = (EditText) findViewById(R.id.longitudeID);
        image = (EditText) findViewById(R.id.latitudeID);

        addRes = (Button) findViewById(R.id.addRes);
        add = (Button) findViewById(R.id.addImage);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1 );

            }
        });


        addRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadImage();

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode==RESULT_OK && data.getData()!=null && data!=null ){
            imageUri = data.getData();

        }


    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));

    }

    private void UploadImage(){
        if(imageUri!=null) {
            StorageReference fileReference = storageRefrence.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
            fileReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String TempImageName = ResturantName.getText().toString().trim();
                    Toast.makeText(ResturantListAdmin.this, "successfully add image", Toast.LENGTH_SHORT).show();

                    String id = databaseReference.push().getKey();
                    Resturant resturant = new Resturant(id,TempImageName,latitude.getText().toString(),longitude.getText().toString(),taskSnapshot.getUploadSessionUri().toString());
                    databaseReference.child(id).setValue(resturant);
                    Toast.makeText(ResturantListAdmin.this,"successfully add resturant",Toast.LENGTH_SHORT).show();


                }
            });


        }else{
            Toast.makeText(ResturantListAdmin.this, "please add image", Toast.LENGTH_SHORT).show();

        }

    }




}





