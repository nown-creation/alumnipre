package com.example.darkmode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<com.example.darkmode.PostsAdapter.PostViewHolder> {

    private List<com.example.darkmode.PostItem> postItems;

    public PostsAdapter(List<com.example.darkmode.PostItem> postItems) {
        this.postItems = postItems;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PostViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.post_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setPostImage(postItems.get(position));
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder
    {
        RoundedImageView postImageView;
        PostViewHolder(@NonNull View itemView)
        {
            super(itemView);
            postImageView = itemView.findViewById(R.id.imagePost);
        }

        void setPostImage(com.example.darkmode.PostItem postItem)
        {
            postImageView.setImageResource(postItem.getImage());
        }
    }

}
