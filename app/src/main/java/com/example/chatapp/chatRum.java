package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class chatRum extends AppCompatActivity {


    String name;
    String password;

    private RecyclerView recycView;
    private ValueAdapter recycAdap;

    private EditText editTextChat;
    private Button buttonChat;
    private Button testX;

    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_rum);

        editTextChat = findViewById(R.id.editTextChat);
        buttonChat = findViewById(R.id.buttonChat);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        name = extras.getString("incoming_name");
        // password = extras.getString("incoming_password");


        database = FirebaseDatabase.getInstance();

        ArrayList<String> omega = new ArrayList<String>();
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");
        omega.add("test1");




        recycView = findViewById(R.id.recycViewXML);
        recycView.setLayoutManager(new LinearLayoutManager(this));
        recycAdap = new ValueAdapter(omega);
        recycView.setAdapter(recycAdap);

        DatabaseReference ref = database.getReference("chatMessage");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String go = String.valueOf(snapshot.getValue());

                recycAdap.addData(go);

                Intent intent = new Intent(chatRum.this, ForegroundService.class);
                Bundle extras = new Bundle();
                extras.putString("incoming_message", go);
                intent.putExtras(extras);
                ContextCompat.startForegroundService(chatRum.this, intent);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });




    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickChatButton(View view) {


        LocalDateTime tid = null;
        LocalDateTime tid2 = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            tid2 = LocalDateTime.parse("2021-09-30T15:30:20.312");
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            tid = LocalDateTime.now();
        }

        String cp = String.valueOf(tid.compareTo(tid2));

        Log.d("firebase", cp ); // -1 blir resultat för tid är tidigare än tid2, annars blir det 1..

        String textInput = editTextChat.getText().toString();

       DatabaseReference ref2 = database.getReference("chatMessage");
       ref2.setValue(name+": "+textInput);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()){
            case R.id.login:


                return true;
            case R.id.chat:

                //startActivity(new Intent(this, Formular.class).putExtra("inlog",userS.get(arrayPlace)));


                return true;
            case R.id.saved:
                startActivity(new Intent (this, savedmessages.class));


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onClickRecyc(View view) {
        ((InputMethodManager) chatRum.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

  /*  @Override
    public void onClick(View view, int position){
        recycView.findViewHolderForAdapterPosition(position);
    }*/

}