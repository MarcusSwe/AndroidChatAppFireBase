package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ImageView imageFocus;
    EditText editTextName;
    EditText editTextPassword;

    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFocus = findViewById(R.id.imageView);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        database = FirebaseDatabase.getInstance();

        DatabaseReference ref = database.getReference("users").child("testuser"); //add new users

        ref.setValue("testlosen");

    }

    public void onClickImageView(View view) {
        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
        imageFocus.requestFocus();
    }


    public void onClickloginButton(View view) {
      //  String getName = editTextName.getText().toString();

        final String[] getName = {""};
        Intent goToChat = new Intent(this, chatRum.class);

        DatabaseReference ref = database.getReference("users").child("testuser");

        ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    getName[0] = String.valueOf(task.getResult().getValue());

                    String getPassword = editTextPassword.getText().toString();


                    Bundle extras = new Bundle();

                    Log.d("firebase", "sadgasdf");

                    extras.putString("incoming_name", getName[0]);
                    extras.putString("incoming_password", getPassword);
                    goToChat.putExtras(extras);
                    startActivity(goToChat);
                }

            }
        });






    }



}