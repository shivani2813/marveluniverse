package com.example.marveluniverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
     Toolbar toolbar;
     Client client;
     RecyclerView recyclerView;
    ArrayList<additem> ad = new ArrayList<>();
    Adapter adapter;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.text);
        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        client =new Client();
        recyclerView=findViewById(R.id.recyclerview);
        adapter adapter1 = new adapter();
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,6));
        recyclerView.setAdapter(adapter1);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        additem obj=new additem();
        obj.setName("Name");
        obj.setImage("Image");
        ad.add(obj);


        Call<gSonmodal> call=client.getAPIclient().getData("f73f39d9b08e1951aeb5d273b6241f24c23eec00");
        call.enqueue(new Callback<gSonmodal>() {
            @Override
            public void onResponse(Call<gSonmodal> call, Response<gSonmodal> response) {
                gSonmodal obj=response.body();

             //   Log.e("mdfdfdsg:",obj.getMessage());

            }

            @Override
            public void onFailure(Call<gSonmodal> call, Throwable t) {

            }
        });

    }



}

