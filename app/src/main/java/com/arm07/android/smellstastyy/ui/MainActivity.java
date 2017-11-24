package com.arm07.android.smellstastyy.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.arm07.android.smellstastyy.R;

public class MainActivity extends AppCompatActivity implements ListFragment.OnListRecipeSelected {

    public static final String LIST_FRAGMENT="list_fragment";
    public static final String VIEWPAGE_FRAGMENT="viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet=getResources().getBoolean(R.bool.is_tablet);
        Toast.makeText(MainActivity.this,isTablet+"",Toast.LENGTH_SHORT).show();
        //Refactoring of code to support rotation of phone without creating 2 fragmemts (to avoid)
        ListFragment savedFragment= (ListFragment) getSupportFragmentManager()
                .findFragmentByTag(LIST_FRAGMENT);
        if (savedFragment == null) {
            ListFragment listFragment = new ListFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, listFragment,LIST_FRAGMENT);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onRecipeSelected(int index) {

        ViewPagerFragment viewFragment = new ViewPagerFragment();

        Bundle bundle=new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
        viewFragment.setArguments(bundle);
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder,viewFragment,VIEWPAGE_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
