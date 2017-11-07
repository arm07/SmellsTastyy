package com.arm07.android.smellstastyy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arm07.android.smellstastyy.R;

/**
 * Created by rashmi on 11/7/2017.
 */

public class ViewPagerFragment extends android.support.v4.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_viewpager,container,false);
        return view;
    }
}
