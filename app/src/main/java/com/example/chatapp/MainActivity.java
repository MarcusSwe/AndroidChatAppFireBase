package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        /*DatabaseReference ref = database.getReference("users").child("testuser"); //add new users

        ref.setValue("testlosen");*/

    }

    public void onClickImageView(View view) {
        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
        imageFocus.requestFocus();
    }


    public void onClickloginButton(View view) {

        Intent goToChat = new Intent(this, chatRum.class);

        DatabaseReference ref = database.getReference("users");

        String nameInput = editTextName.getText().toString();
        String passInput = editTextPassword.getText().toString();
        Pattern pattern = Pattern.compile(".*" + nameInput + "=" + passInput + ".*");
        final Matcher[] testPattern = new Matcher[1];
        final Boolean[] correctPassword = {false};

        ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(pattern));
                    testPattern[0] = pattern.matcher(String.valueOf(task.getResult().getValue()));
                    if(testPattern[0].matches() && !"".equals(passInput)){
                        correctPassword[0] = true;
                    }

                    if(!correctPassword[0]){
                        Toast.makeText(MainActivity.this, "WRONG PASSWORD!",Toast.LENGTH_LONG).show();
                    } else {
                        Bundle extras = new Bundle();
                        extras.putString("incoming_name", nameInput);
                      //  extras.putString("incoming_password", passInput);
                        goToChat.putExtras(extras);
                        startActivity(goToChat);
                    }
                }
            }
        });
    }


    public void onClickCreateButton(View view) {

        DatabaseReference ref = database.getReference("users");

        String nameInput = editTextName.getText().toString()+"=";
        Pattern pattern = Pattern.compile(".*"+nameInput+".*");
        final Matcher[] testPattern = new Matcher[1];
        final Boolean[] userXist = {false};

        ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    testPattern[0] = pattern.matcher(String.valueOf(task.getResult().getValue()));
                    if(testPattern[0].matches()){
                        userXist[0] = true;
                    }
                    if(userXist[0]) {
                        Toast.makeText(MainActivity.this, "USER EXISTS!",Toast.LENGTH_LONG).show();
                    } else {
                        if(editTextName.getText().toString().equals("") && editTextPassword.getText().toString().equals("")) {

                        }else {
                            DatabaseReference ref2 = database.getReference("users").child(editTextName.getText().toString());
                            ref2.setValue(editTextPassword.getText().toString());
                            Toast.makeText(MainActivity.this, "User created!",Toast.LENGTH_LONG).show();

                        }
                    }
                }
            }
        });
    }

    @Override
    public void onNewIntent(Intent i) {
        super.onNewIntent(i);

        editTextName.setText("Logged out");
        editTextPassword.setText("");
        }





}