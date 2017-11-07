package com.arm07.android.smellstastyy.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.arm07.android.smellstastyy.R;
import com.arm07.android.smellstastyy.model.Recipes;

public class MainActivity extends AppCompatActivity implements ListFragment.OnListRecipeSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refactoring of code to support rotation of phone without creating 2 fragmemts (to avoid)
        ListFragment savedFragment= (ListFragment) getSupportFragmentManager().findFragmentById(R.id.placeholder);
        if (savedFragment == null) {
            ListFragment listFragment = new ListFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, listFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onRecipeSelected(int index) {
        Toast.makeText(MainActivity.this,"recipe selected!"+ Recipes.names[index],Toast.LENGTH_SHORT).show();

        ViewPagerFragment viewFragment = new ViewPagerFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, viewFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
