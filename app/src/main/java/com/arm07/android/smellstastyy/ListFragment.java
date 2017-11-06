package com.arm07.android.smellstastyy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rashmi on 11/5/2017.
 */

public class ListFragment extends LoggingFragment {

    public interface OnListRecipeSelected{
        void onRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(LoggingFragment.TAG,"onCreateView");
        OnListRecipeSelected listener= (OnListRecipeSelected) getActivity();

        View view=inflater.inflate(R.layout.fragment_list,container,false);
        //Recycler view is inflated into the view, adapter is attached and layout manager is passed to the view
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.listRecyclerView);
        ListAdapter adapter=new ListAdapter(listener);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
