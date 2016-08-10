package com.example.darth.search_recyclerview.utils;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.darth.search_recyclerview.R;
import com.example.darth.search_recyclerview.model.Post;

/**
 * Created by diana on 8/10/16.
 */
public class PostsViewHolder extends RecyclerView.ViewHolder{
    private final CardView cardView;

    public final TextView mTitleTextView;
    public final TextView mBodyTextView;
    public final TextView mUsernameTextView;


    public PostsViewHolder(View v) {
        super(v);
        cardView = (CardView) v.findViewById(R.id.card_view);
        mTitleTextView = (TextView) v.findViewById(R.id.title_text_view);
        mBodyTextView = (TextView) v.findViewById(R.id.body_text_view);
        mUsernameTextView = (TextView) v.findViewById(R.id.user_id_text_view);
    }

    public void bind(Post post) {
        mTitleTextView.setText(post.getTitle());
        mBodyTextView.setText(post.getBody());
        mUsernameTextView.setText(String.valueOf(post.getUserId()));
    }
}
