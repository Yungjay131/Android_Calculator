package com.slyworks.calculator.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.slyworks.calculator.R;


public class ViewPagerAdapter extends PagerAdapter {
    //creating array to store layouts
   private int[] mLayouts = {R.layout.ui, R.layout.ui2};
   private LayoutInflater layoutInflater;

   //creating context to be used
    private Context context;



    //creating constructor to initialise context for this activity
    ViewPagerAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return mLayouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        //returning the type of view
        return (view == (LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View one = layoutInflater.inflate(R.layout.ui,container,false);
        View two = layoutInflater.inflate(R.layout.ui2,container,false);

        View[] mViewArray = {one,two};

        container.addView(mViewArray[position]);
        return mViewArray[position];
    }

    //destroying the activity as soon as the user swipes away from it
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }
}
