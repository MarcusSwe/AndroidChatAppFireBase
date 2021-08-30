package com.example.chatapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class serviceLoadMessages extends Service {

    private FirebaseDatabase database;
    private int omegaLOL = 0;


 /*      public int onStartCommand(){
     database = FirebaseDatabase.getInstance();



        DatabaseReference ref = database.getReference("users");

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


                }

            }
        });



        //service..

        recycView = findViewById(R.id.recycViewXML);
        recycView.setLayoutManager( new LinearLayoutManager(this));
        recycAdap = new ValueAdapter();
        recycView.setAdapter(recycAdap);

    }*/


    public serviceLoadMessages() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }




}