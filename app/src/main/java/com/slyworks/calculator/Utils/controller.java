package com.slyworks.calculator.Utils;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.slyworks.calculator.Calculations;
import com.slyworks.calculator.MainActivity;
import com.slyworks.calculator.Numbers;
import com.slyworks.calculator.R;

import java.util.ArrayList;
import java.util.Map;
//import static com.slyworks.calculator.MainActivity.textView1;


public class controller{
    //class for handling calculations and managing data
    public static String s = "";
    boolean isChanged = false;

    public static ArrayList<Integer> numbers = new ArrayList<>();
    public static ArrayList<Integer> operations = new ArrayList<>();

    MainActivity mMainActivity = new MainActivity();
    private boolean isThereTrigOp;
    private int trig_index;

    public View mView;
    public int textView_id;
    private boolean  mIsLastEnteredNumber = false;

    private static ArrayList<Numbers> mNumbers = new ArrayList<>();
    private Calculations mCalculations = new Calculations();
    //method for appending numbers to textView
    public void appendNumber(View button_clicked, Map<Integer, String> number_map) {
           if(button_clicked.getId()==R.id.btnPoint && s.contains("."))
               return;

            s = s + number_map.get(button_clicked.getId());
            mMainActivity.callToGetValue(number_map.get(button_clicked.getId()), 1);
        }

    //appending to textView
    public void writeToTextView(String s) {
        //TODO: use fragment Observer pattern for this part
        TextView mTextView1 = mView.findViewById(textView_id);
        mTextView1.append(s);
}
    //method for doing the calculation
    public void calculate(View button_clicked, Map<Integer, String> operator_map, Map<String, Integer> operator_map2) {
        if(!s.equals("")) {
            //writing to ArrayLists
            mNumbers.add(new Numbers(s));

            int id = button_clicked.getId();
            operations.add(operator_map2.get(operator_map.get(id)));
            mMainActivity.callToGetValue(operator_map.get(button_clicked.getId()), 1);
            s = "";
        }
    }


    //method for equals button
    public void equals() {
            //if it is an edit to an existing number
            //remove the last number and add the current value of s
        Numbers ans = null;
        boolean isTherePreviousCalculation = false;
        mNumbers.add(new Numbers(s));

            Number answer = 0;
            //for the actualCalculation

            for (int i = 0; i < mNumbers.size() - 1; i++) {
                switch (operations.get(i)) {
                    case 1:
                         if(isTherePreviousCalculation) {
                             answer = mCalculations.add(new Numbers(answer.toString()), mNumbers.get(i+1));
                         }else {
                             answer = mCalculations.add(mNumbers.get(i), mNumbers.get(i + 1));
                             isTherePreviousCalculation = true;
                         }
                        break;
                    case 2:
                        if(isTherePreviousCalculation) {
                            answer = mCalculations.subtract(new Numbers(answer.toString()), mNumbers.get(i+1));
                        }else {
                            answer = mCalculations.subtract(mNumbers.get(i), mNumbers.get(i + 1));
                            isTherePreviousCalculation = true;
                        }
                        break;
                    case 3:
                        if(isTherePreviousCalculation) {
                            answer = mCalculations.multiply(new Numbers(answer.toString()), mNumbers.get(i+1));
                        }else {
                            answer = mCalculations.multiply(mNumbers.get(i), mNumbers.get(i + 1));
                            isTherePreviousCalculation = true;
                        }
                        break;
                    case 4:
                        if(isTherePreviousCalculation) {
                            answer = mCalculations.divide(new Numbers(answer.toString()), mNumbers.get(i+1));
                        }else {
                            answer = mCalculations.divide(mNumbers.get(i), mNumbers.get(i + 1));
                            isTherePreviousCalculation = true;
                        }
                        break;
                    default:
                        break;
                }
            }

            mMainActivity.callToGetValue(answer.toString(), 2);
    }


    //method for clearing last entered item
    public void clear() {
        //mMainActivity.callToClearLastEnteredValue();
     /*  if(textView1.getText().toString().length() == 1)
           textView1.setText("");
       if(textView1.getText().length() >= 1) {
           textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1));

           if(!sb.equals(""))
           sb = sb.substring(0,sb.length()-1);

           //if the last thing entered is a number
           //check if it has more than one digit, and delete accordingly
           if (numbers.size() > 0) {
               String str = String.valueOf(numbers.get(numbers.size() - 1));

               if (isLastEnteredNum && str.length() > 1) {
                   numbers.remove(numbers.size() - 1);
                   sb = str.substring(0, str.length() - 1);
               } else if(isLastEnteredNum && str.length() == 1) {
                   numbers.remove(numbers.size() - 1);
                   isLastEnteredNum = false;
               } else if (!isLastEnteredNum) {
                   operations.remove(operations.size() - 1);
                   sb = String.valueOf(numbers.get(numbers.size() - 1));
                   numbers.remove(numbers.size() - 1);
               }
           }
       }
*/
    }


    //method for initialising buttons
    public ArrayList<Button> initialise(View view, Button[] array, int[] array2) {
        ArrayList<Button> mButtonList = new ArrayList<>();
        for (int i = 0; i < array2.length; i++) {
            array[i] = view.findViewById(array2[i]);
            mButtonList.add(array[i]);
        }
        return mButtonList;
    }


}