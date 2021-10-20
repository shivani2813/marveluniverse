package com.example.marveluniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SplashActivity3 extends AppCompatActivity {
    View I1;
    FirebaseAuth mAuth;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);


        mAuth = FirebaseAuth.getInstance();
            FirebaseDatabase database=FirebaseDatabase.getInstance();
            DatabaseReference reference=database.getReference("messs");
            reference.setValue("test");
            I1 = findViewById(R.id.LE1);

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(2000);
                        if (mAuth.getCurrentUser() != null) {
                            Intent intent = new Intent(SplashActivity3.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }
    }

