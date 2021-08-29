package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class chatRum extends AppCompatActivity {

    String name;
    String password;

    private RecyclerView recycView;
    private ValueAdapter recycAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_rum);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        name = extras.getString("incoming_name");
       // password = extras.getString("incoming_password");

        recycView = findViewById(R.id.recycViewXML);
        recycView.setLayoutManager( new LinearLayoutManager(this));

        recycAdap = new ValueAdapter();

        recycView.setAdapter(recycAdap);

    }
}