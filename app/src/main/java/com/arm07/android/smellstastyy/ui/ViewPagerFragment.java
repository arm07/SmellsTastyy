package com.arm07.android.smellstastyy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arm07.android.smellstastyy.R;
import com.arm07.android.smellstastyy.model.Recipes;

/**
 * Created by rashmi on 11/7/2017.
 */

public class ViewPagerFragment extends android.support.v4.app.Fragment{

    public static final String KEY_RECIPE_INDEX="recipe_index";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        int index=getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        //Toast.makeText(getActivity(),"recipe selected!"+ Recipes.names[index],Toast.LENGTH_SHORT).show();
        View view=inflater.inflate(R.layout.fragment_viewpager,container,false);

        final IngredientsFragment ingredientsFragment=new IngredientsFragment();
        final DirectionsFragment directionsFragment=new DirectionsFragment();

        ViewPager viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        Bundle bundle=new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        ingredientsFragment.setArguments(bundle);

        bundle=new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        directionsFragment.setArguments(bundle);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position==0)
                    return ingredientsFragment;
                else
                    return directionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"Ingredients":"Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });


        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
