package com.slyworks.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.slyworks.calculator.Adapters.FragPagerAdapter;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity
                  implements OnValueChangedListener,
                             TextWatcher             {

    //TODO:need to find way to implement ViewModel/JSON for persistence
    //TODO:need to learn data types,unboxing again
    //TODO:need to implement swipeView for this project
    private Toolbar toolbar;

    private   TextView textView1;
    private   TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ui);

        //initialising the controller instance
        Controller.getInstance(this);


        //initialising and setting swipeView for the two ui's
        //declaring arrayLists and maps to store operators and numbers

        ViewPager viewPager = findViewById(R.id.viewPager);

        //using fragment instead of views
        FragPagerAdapter adapter = new FragPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

       textView1.addTextChangedListener(this);
       textView2.addTextChangedListener(this);
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
        //Controller control = new Controller();
       //control.writeToTextView( this.textView1.getRootView(), this.textView1.getId(), sb);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //TODO:code to navigate back to first fragment
    }


    @Override
    public void onChanged( Integer operation, @Nullable String value) {
       switch(operation){
           case Constants.APPEND:
               textView1.append(value);
               break;
           case Constants.SET:
               textView2.setText(value);
               break;
           case Constants.REMOVE_LAST_DIGIT:
               textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length()-1));
               break;
           case Constants.CLEAR_ALL:
               textView2.setText("");
               break;
       }
    }

    //TextWatcher methods
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}


