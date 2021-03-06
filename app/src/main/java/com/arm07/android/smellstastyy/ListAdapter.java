package com.arm07.android.smellstastyy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arm07.android.smellstastyy.model.Recipes;
import com.arm07.android.smellstastyy.ui.ListFragment;


/**
 * Created by rashmi on 11/5/2017.
 */

public class ListAdapter extends RecyclerView.Adapter{
    private final ListFragment.OnListRecipeSelected mListener;

    //private final ListFragment.OnListRecipeSelected mListener;

    public ListAdapter(ListFragment.OnListRecipeSelected listener) {
            mListener=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView=(TextView)itemView.findViewById(R.id.itemText);
            mImageView=(ImageView)itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mIndex=position;
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            mListener.onRecipeSelected(mIndex);
        }
    }
}