package com.arm07.android.smellstastyy;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends LoggingActivity implements ListFragment.OnListRecipeSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment=new ListFragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction fragmentTransaction=manager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder,listFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onRecipeSelected(int index) {
        Toast.makeText(MainActivity.this,"recipe selected!"+Recipes.names[index],Toast.LENGTH_SHORT).show();
    }
}
