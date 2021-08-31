package com.example.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ValueAdapterSaved extends RecyclerView.Adapter<ValueAdapterSaved.ViewHolder> {

    private ArrayList<String> messageRaid;

    public ValueAdapterSaved(ArrayList<String> inc){
        messageRaid= inc;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView messages;

        public ViewHolder(View itemView) {
            super(itemView);

            messages = itemView.findViewById(R.id.textViewSaved);

        }

        public TextView getMessages(){
            return messages;
        }

    }




    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycsaved, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ValueAdapterSaved.ViewHolder holder, int position) {

        holder.getMessages().setText(messageRaid.get(position));

    }

    @Override
    public int getItemCount() {
        return messageRaid.size();
    }





}