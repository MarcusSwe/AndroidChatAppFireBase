package com.example.chatapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ViewHolder> {

    private FirebaseDatabase database;

    private ArrayList<String> messages;



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


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyc, viewGroup, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ValueAdapter.ViewHolder holder, int position) {

        holder.getChatText().setText(messages.get(position));
        Log.d("firebase", messages.get(position));



    }

    @Override
    public int getItemCount() {
        return messages.size();
    }



}



