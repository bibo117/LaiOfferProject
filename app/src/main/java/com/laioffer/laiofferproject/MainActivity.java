package com.laioffer.laiofferproject;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity implements RestaurantListFragment
        .OnItemSelectListener {
    private RestaurantListFragment mListFragment;
    private RestaurantGridFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //add list view
        mListFragment = new RestaurantListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                mListFragment).commit();
        //add Gridview
        if (isTablet()) {
            mGridFragment = new RestaurantGridFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_grid_container,
                    mGridFragment).commit();
        }
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }


    @Override
    public void onItemSelected(int position){
        mGridFragment.onItemSelected(position);
    }


}
