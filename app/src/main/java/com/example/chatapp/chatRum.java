package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class chatRum extends AppCompatActivity {

    String name;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_rum);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        name = extras.getString("incoming_name");
        password = extras.getString("incoming_password");

        TextView test = findViewById(R.id.textView);
        test.setText(name+" "+password);
    }
}