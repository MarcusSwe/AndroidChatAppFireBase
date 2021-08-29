package com.example.chatapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ViewHolder> {


    private String[] testTitle= {"Item sdfsdf1","Item 2sdfafasd", "Item 3sdfafsd"};

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

        holder.getChatText().setText(testTitle[position]);
        Log.d("firebase", testTitle[position]);

    }

    @Override
    public int getItemCount() {
        return testTitle.length;
    }



}



