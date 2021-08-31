package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class savedmessages extends AppCompatActivity {

    private DBHelper dbHelper;
    private RecyclerView recycView;
    private ValueAdapterSaved recycAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedmessages);

        dbHelper = new DBHelper(savedmessages.this);

        ArrayList<String> omegaX = new ArrayList<>();

        omegaX = dbHelper.wholeTable();


        recycView = findViewById(R.id.recycViewSaved);
        recycView.setLayoutManager(new LinearLayoutManager(this));
        recycAdap = new ValueAdapterSaved(omegaX);
        recycView.setAdapter(recycAdap);

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

                startActivity(new Intent(this, MainActivity.class));

                return true;
            case R.id.chat:


                startActivity(new Intent(this, chatRum.class));

                return true;
            case R.id.saved:



                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onNewIntent(Intent i) {
        super.onNewIntent(i);


    }





}