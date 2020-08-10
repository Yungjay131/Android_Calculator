package com.slyworks.calculator.Utils;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.slyworks.calculator.Calculations;
import com.slyworks.calculator.MainActivity;
import com.slyworks.calculator.Numbers;
import com.slyworks.calculator.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import static com.slyworks.calculator.MainActivity.textView1;


public class controller{
    //class for handling calculations and managing data
    private MainActivity mMainActivity = new MainActivity();
    private static String mNumberEntered;
    private static List<Numbers> mNumbersList = new ArrayList<>();
    Calculations mCalculations = new Calculations();

    //endregion

    //method for appending numbers to textView
    public void appendNumber(View button_clicked, Map<Integer, String> number_map) {

        }

    //appending to textView
    public void writeToTextView(String s) {
        //TODO: use fragment Observer pattern for this part
}
    //method for doing the calculation
    public void calculate(View button_clicked, Map<Integer, String> operator_map, Map<String, Integer> operator_map2) {
        String s = operator_map.get(button_clicked.getId());
        int id = operator_map2.get(s);
        mMainActivity.callToGetValue(s, 1);
        if(mNumbersList.size() == 0){
            mNumberEntered = "1";
        }
        addToList(id);
        mNumberEntered = "";
    }
    public void addToList(int id){
        int operation = Numbers.NO_OPERATION;
        boolean isThereAnotherNumber  = true;
        switch(id){
            case 0:
                operation = Numbers.NO_OPERATION;
                break;
            case 1:
                operation = Numbers.ADD;
                break;
            case 2:
                operation = Numbers.SUBTRACT;
                break;
            case 3:
                operation = Numbers.MULTIPLY;
                break;
            case 4:
                operation = Numbers.DIVIDE;
                break;
            case 5:
                operation = Numbers.SIN;
                isThereAnotherNumber = false;
                break;
            case 6:
                operation = Numbers.COS;
                isThereAnotherNumber = false;
                break;
            case 7:
                operation = Numbers.TAN;
                isThereAnotherNumber = false;
                break;
        }
        mNumbersList.add(new Numbers(mNumberEntered,operation, isThereAnotherNumber));
    }
    //method for equals button
    public void equals() {
//TODO:need to find another way of implementing the calculations
        addToList(Numbers.NO_OPERATION);
        String ans = mCalculations.performCalculations(mNumbersList);
        mMainActivity.callToGetValue(ans, 2);
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