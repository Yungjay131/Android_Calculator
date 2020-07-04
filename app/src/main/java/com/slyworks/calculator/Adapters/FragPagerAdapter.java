package com.slyworks.calculator.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.slyworks.calculator.UIFragments.UIFragment_one;
import com.slyworks.calculator.UIFragments.UIFragment_two;

public class FragPagerAdapter extends FragmentStatePagerAdapter {

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        //fragments must be initialised here
        UIFragment_one ui_one = new UIFragment_one();
        UIFragment_two ui_two = new UIFragment_two();
        Fragment[] frag_array =  {ui_one, ui_two};

        while(i<0){
            i = i + 1;
        }
        return frag_array[i];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
