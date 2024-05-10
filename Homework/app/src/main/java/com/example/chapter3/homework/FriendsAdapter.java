package com.example.chapter3.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.chapter3.homework.domain.Friend;

import java.util.List;

/**
 * @author z'
 * @version 1.0
 * @description: TODO
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    private List<Friend> friendList;

    public FriendsAdapter(List<Friend> friendList) {
        this.friendList = friendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Friend friend = friendList.get(position);
        holder.textName.setText(friend.getName());
        holder.textStatus.setText(friend.isOnline() ? "在线" : "离线");
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName;
        public TextView textStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
            textStatus = itemView.findViewById(R.id.text_status);
        }
    }
}

