package com.example.chatapp;

import android.content.Context;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ViewHolder> {

    //private FirebaseDatabase database;

    private ArrayList<String> messages;

    private TextView chatText;
    private Button buttonS;
    private String idText;
    private String idButton;
    private int xx = 0;


    public ValueAdapter(ArrayList<String> inc) {
        messages = inc;
    }

    public void addData(String newMessage){
        messages.add(newMessage);
        notifyItemInserted(messages.size() -1);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView chatText;
        private Button buttonS;


        public ViewHolder(View itemView) {
            super(itemView);

            chatText = itemView.findViewById(R.id.textViewChat);
            buttonS = itemView.findViewById(R.id.buttonSave);



        }

        public TextView getChatText() {
            return chatText;
        }

        public Button getChatButton() {
            return buttonS;
        }




    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyc, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ValueAdapter.ViewHolder holder, int position) {



        holder.getChatButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("firebase", String.valueOf(holder.getChatText().getText()));
                
            }
        });

        holder.getChatText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((InputMethodManager) holder.itemView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        holder.getChatText().setText(messages.get(position));
        Log.d("firebase", messages.get(position));


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }



}



