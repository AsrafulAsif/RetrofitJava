package com.example.retrofitjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userHolder> {
    MainActivity mainActivity;
    List<userModel> allUserList;
    public userAdapter(MainActivity mainActivity, List<userModel> allUserList) {
        this.mainActivity = mainActivity;
        this.allUserList = allUserList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_user,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull userAdapter.userHolder holder, int position) {
        holder.textView.setText(allUserList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return allUserList.size();
    }
    class userHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public userHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
