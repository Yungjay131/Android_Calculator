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

public class UIFragment_two extends Fragment implements View.OnClickListener{

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPlus,btnMinus,
    btnDivide,btnMultiply,btnSin,btnCos,btnTan,btnClear,btnEquals,btnPoint,btnBracketOpen,btnBracketClose,
    btnLog,btnSqrt,btnExponential,btnPermutation,btnPie,btnLn,btnPower;

    Button[] mButtons = {btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnMinus,btnPlus,
            btnDivide,btnMultiply,btnSin,btnCos,btnTan,btnClear,btnEquals,btnPoint,btnBracketOpen,btnBracketClose,
            btnLog,btnSqrt,btnExponential,btnPermutation,btnPie,btnLn,btnPower};


     int[] mButtonsIDs = {R.id.btn0_2,R.id.btn1_2,R.id.btn2_2,R.id.btn3_2,R.id.btn4_2,R.id.btn5_2,R.id.btn6_2,R.id.btn7_2,R.id.btn8_2,
             R.id.btn9_2,R.id.btnMinus2,R.id.btnPlus2,R.id.btnDivide2,R.id.btnMultiply2,R.id.btnSin,R.id.btnCos,R.id.btnTan,
             R.id.btnClear2,R.id.btnEquals2,R.id.btnPoint2, R.id.btnBracket_open,R.id.btnBracket_close, R.id.btnLog,R.id.btnSquareRoot,
             R.id.btnExponential,R.id.btnPermutation,R.id.btnPie,R.id.btnLn,R.id.btnRaise_to_power};

     Controller mControl = Controller.getInstance();

    public Map<Integer, String> mMap = new HashMap<>();
    public Map<String , Integer> operator_map2 = new HashMap<>();

    //maps for trig
    public Map<String, Integer>  trig_map2 = new HashMap<>();
     ArrayList<Button> mButtonsList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui2, container, false);
        mButtonsList = mControl.initialise(view, mButtons, mButtonsIDs);

        //setting OnClickListener
        for(Button btn:mButtonsList)
            btn.setOnClickListener(this);

        for(int i=0;i<10;i++)
            mMap.put(mButtonsList.get(i).getId(), String.valueOf(i));

        mMap.put(mButtonsList.get(10).getId(), "-");
        mMap.put(mButtonsList.get(11).getId(), "+");
        mMap.put(mButtonsList.get(12).getId(), "/");
        mMap.put(mButtonsList.get(13).getId(), "x");
        mMap.put(mButtonsList.get(14).getId(), "Sin");
        mMap.put(mButtonsList.get(15).getId(), "Cos");
        mMap.put(mButtonsList.get(16).getId(), "Tan");
        mMap.put(mButtonsList.get(22).getId(), "Log");

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn0_2:
            case R.id.btn1_2:
            case R.id.btn2_2:
            case R.id.btn3_2:
            case R.id.btn4_2:
            case R.id.btn5_2:
            case R.id.btn6_2:
            case R.id.btn7_2:
            case R.id.btn8_2:
            case R.id.btn9_2:
                mControl.check(null, Integer.valueOf(mMap.get(v.getId())));
            case R.id.btnPoint2:
                break;
            case R.id.btnPlus2:
            case R.id.btnMinus2:
            case R.id.btnMultiply2:
            case R.id.btnDivide2:
            case R.id.btnSin:
            case R.id.btnCos:
            case R.id.btnTan:
                mControl.check(mMap.get(v.getId()),null);
                break;
            case R.id.btnEquals2:
                mControl.calculationQuery();
                break;
            case R.id.btnClear2:
                break;

            case R.id.btnBracket_open:
            case R.id.btnBracket_close:

            case R.id.btnLog:

            case R.id.btnSquareRoot:
            case R.id.btnExponential:
            case R.id.btnPermutation:
            case R.id.btnPie:
            case R.id.btnLn:
            case R.id.btnRaise_to_power:
            default:
                break;
        }
    }
}
