package com.slyworks.calculator.UIFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.slyworks.calculator.Controller;
import com.slyworks.calculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UIFragment_one extends Fragment implements View.OnClickListener {

    //declaring buttons for this fragment view
    public Button  btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnMinus, btnPlus, btnDivide, btnMultiply, btnPoint, btnEquals, btnClear;

    public Button[] mButtons = { btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnMinus, btnPlus, btnDivide, btnMultiply, btnPoint, btnEquals, btnClear};

    public int[] mButtonsIDs = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
            R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btnMinus,R.id.btnPlus,
            R.id.btnDivide,R.id.btnMultiply,R.id.btnPoint,R.id.btnEquals,R.id.btnClear};


    private final String TAG = getClass().getSimpleName();

    public Map<Integer, String> mMap = new HashMap<>();
    public Map<String , Integer> operator_map2 = new HashMap<>();

    Controller mControl = Controller.getInstance();
    public  ArrayList<Button> mButtonsList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.ui, container, false);
       mControl = Controller.getInstance();
        mButtonsList = mControl.initialise(view, mButtons, mButtonsIDs);

        for(int i=0;i<10;i++)
            mMap.put(mButtonsList.get(i).getId(),String.valueOf(i));

        mMap.put(R.id.btnPoint, ".");

        mMap.put(mButtonsList.get(10).getId(), "-");
        mMap.put(mButtonsList.get(11).getId(), "+");
        mMap.put(mButtonsList.get(12).getId(), "/");
        mMap.put(mButtonsList.get(13).getId(), "x");


       for(Button btn:mButtonsList)
           btn.setOnClickListener(this);

        return view;
    }
    public void point(View view) {

    }

    //clear
    public void clearText(View view) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
            case R.id.btn2:
            case R.id.btn1:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                mControl.append(mMap.get(view.getId()));
                break;
            case R.id.btnPoint:
                break;
            case R.id.btnPlus:
            case R.id.btnMinus:
            case R.id.btnMultiply:
            case R.id.btnDivide:
                mControl.getOperation(mMap.get(view.getId()));
                break;
            case R.id.btnEquals:
                mControl.calculationQuery();
                break;
            case R.id.btnClear:
                break;

            default:
                break;
        }

    }


}
