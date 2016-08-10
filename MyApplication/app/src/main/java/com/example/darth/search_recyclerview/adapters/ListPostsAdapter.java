package com.example.darth.search_recyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.darth.search_recyclerview.R;
import com.example.darth.search_recyclerview.model.Post;
import com.example.darth.search_recyclerview.utils.PostsViewHolder;
import java.util.ArrayList;
import java.util.List;

public class ListPostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {

    private final LayoutInflater mInflater;
    private final List<Post> mPosts;

    public ListPostsAdapter(Context context, List<Post> models) {
        mInflater = LayoutInflater.from(context);
        mPosts = new ArrayList<>(models);
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.card_view, parent, false);
        return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {
        final Post model = mPosts.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void animateTo(List<Post> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<Post> newPosts) {
        for (int i = mPosts.size() - 1; i >= 0; i--) {
            final Post post = mPosts.get(i);
            if (!newPosts.contains(post)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Post> newPosts) {
        for (int i = 0, count = newPosts.size(); i < count; i++) {
            final Post post = newPosts.get(i);
            if (!mPosts.contains(post)) {
                addItem(i, post);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Post> newPosts) {
        for (int toPosition = newPosts.size() - 1; toPosition >= 0; toPosition--) {
            final Post post = newPosts.get(toPosition);
            final int fromPosition = mPosts.indexOf(post);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Post removeItem(int position) {
        final Post post = mPosts.remove(position);
        notifyItemRemoved(position);
        return post;
    }

    public void addItem(int position, Post post) {
        mPosts.add(position, post);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Post post = mPosts.remove(fromPosition);
        mPosts.add(toPosition, post);
        notifyItemMoved(fromPosition, toPosition);
    }
}