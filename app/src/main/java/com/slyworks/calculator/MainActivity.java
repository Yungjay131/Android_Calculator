package com.slyworks.calculator;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.slyworks.calculator.Adapters.FragPagerAdapter;
import com.slyworks.calculator.UIFragments.UIFragment_one;
import com.slyworks.calculator.Utils.controller;

import java.util.Objects;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity{

    //TODO:need to find way to implement JSON for persistence
    //TODO:need to learn data types,unboxing again
    //TODO:need to implement swipeView for this project
    private Toolbar toolbar;

    private  static  TextView textView1;
    private  static TextView textView2;


   TextWatcher mTextWatcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ui);

        //initialising and setting swipeView for the two ui's
        //declaring arrayLists and maps to store operators and numbers

        ViewPager viewPager = findViewById(R.id.viewPager);

        //using fragment instead of views
        FragPagerAdapter adapter = new FragPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

       /* textView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            new controller().equals();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    //method
    public void callToGetValue(String sb,int num){
        setText(sb, num);
    }

    public void setText(String sb, int num){
        switch(num){
            case 1:
                textView1.append(sb);
                break;
            case 2:
                textView2.setText(sb);
        }
    }
    public void callToClearLastEnteredValue(){
        if(textView1.getText().length() > 0)
        textView1.setText(textView1.getText().toString().substring(0,textView1.length()-1));}

//
    public void setTextView1Data(String sb){
        controller control = new controller();
       //control.writeToTextView( this.textView1.getRootView(), this.textView1.getId(), sb);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //TODO:code to navigate back to first fragment
    }
}


