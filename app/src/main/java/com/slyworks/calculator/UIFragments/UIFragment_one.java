package com.slyworks.calculator.UIFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.slyworks.calculator.R;
import com.slyworks.calculator.Controller;

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

    public Map<Integer, String> number_map = new HashMap<>();
    public Map<Integer, String> operator_map = new HashMap<>();
    public Map<String , Integer> operator_map2 = new HashMap<>();

    Controller control = new Controller();
    public  ArrayList<Button> mButtonsList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.ui, container, false);
        mButtonsList = control.initialise(view, mButtons, mButtonsIDs);

        for(int i=0;i<10;i++)
            number_map.put(mButtonsList.get(i).getId(),String.valueOf(i));

        number_map.put(R.id.btnPoint, ".");

        operator_map.put(mButtonsList.get(10).getId(), "-");
        operator_map.put(mButtonsList.get(11).getId(), "+");
        operator_map.put(mButtonsList.get(12).getId(), "/");
        operator_map.put(mButtonsList.get(13).getId(), "x");


        operator_map2.put("+", 1);
        operator_map2.put("-", 2);
        operator_map2.put("x", 3);
        operator_map2.put("/", 4);



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
        Controller control = new Controller();
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
            case R.id.btnPoint:
                break;
            case R.id.btnPlus:
            case R.id.btnMinus:
            case R.id.btnMultiply:
            case R.id.btnDivide:
                control.calculate(view, operator_map, operator_map2);
                break;
            case R.id.btnEquals:
                control.equals();
                break;
            case R.id.btnClear:
                control.clear();
                break;

            default:
                break;
        }

    }


}
