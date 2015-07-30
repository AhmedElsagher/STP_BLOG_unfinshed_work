package com.example.ahmed.stpblog;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class GridActivity extends SingleFragmentActivity {


    @Override
    public Fragment getFragment() {
        return new GridFragment();
    }
}
