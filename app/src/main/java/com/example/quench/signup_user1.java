package com.example.personal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personal.Models.users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup_user1 extends AppCompatActivity {
    Button start;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    EditText email1, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user1);
        start = findViewById(R.id.getstarted);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email1.getText().toString();
                String password = password1.getText().toString();



                mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signup_user1.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                         users user = new users(email1.getText().toString() , password1.getText().toString());
                         String id = task.getResult().getUser().getUid();
                         database.getReference().child("users").child(id).setValue(user);
                                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(signup_user1.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(signup_user1.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        });

            }
        });
    }
}