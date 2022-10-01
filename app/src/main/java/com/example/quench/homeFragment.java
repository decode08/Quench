package com.example.quench;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class homeFragment extends Fragment {

    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    FirebaseStorage storage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageRef = storage.getReference();
//        StorageReference imagesRef = storageRef.child("images");


//        StorageReference spaceRef = storageRef.child("images/space.jpg");
//        imagesRef = spaceRef.getParent();
//        StorageReference rootRef = spaceRef.getRoot();
      View view = inflater.inflate(R.layout.fragment_home, container, false);
return view;
//        @Override
 //       protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//                Bundle extras = data.getExtras();
//                Bitmap imageBitmap = (Bitmap) extras.get("data");
//                imageView.setImageBitmap(imageBitmap);
//            }
      // }
    }
}
