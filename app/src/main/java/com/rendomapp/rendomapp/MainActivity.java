package com.rendomapp.rendomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setData();
        final MyAdapter myAdapter = new MyAdapter(MainActivity.this,arrayList);
        recyclerView.setAdapter(myAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new Model("Hello"));
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    public void setData(){
        arrayList.add(new Model("abc"));
        arrayList.add(new Model("efg"));
        arrayList.add(new Model("hij"));
        arrayList.add(new Model("klm"));
        arrayList.add(new Model("nop"));
        arrayList.add(new Model("qrs"));
        arrayList.add(new Model("tuv"));
    }
}
