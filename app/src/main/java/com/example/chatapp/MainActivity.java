package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageFocus;
    EditText editTextName;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFocus = findViewById(R.id.imageView);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

    }

    public void onClickImageView(View view) {
        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
        imageFocus.requestFocus();
    }


    public void onClickloginButton(View view) {
        String getName = editTextName.getText().toString();
        String getPassword = editTextPassword.getText().toString();

        Intent goToChat = new Intent(this, chatRum.class);
        Bundle extras = new Bundle();

        Log.d("CPCP", getName);

        extras.putString("incoming_name", getName);
        extras.putString("incoming_password", getPassword);
        goToChat.putExtras(extras);
        startActivity(goToChat);


    }



}