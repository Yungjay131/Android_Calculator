package com.slyworks.calculator;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by Joshua Sylvanus, 6:58 AM, 10/2/2020.
 */
public class Calculations2{
    //region Vars
    String answer = "";
    Number num;
    ArrayList<Numbers> a;
    Integer mOperation;
    private Controller2 mController = Controller2.getInstance();
    //endregion

public void insertToQueue(Numbers n){
    if(a == null){
        init();
    }
    a.add(n);
    /*
     *notifying the controller that the queue now has 2 values ,
     * hence calculation can now be performed
     */
    if(a.size() >= 2){
        mController.setBool(true);
    }

}
public void insertOperation(Integer i){
    mOperation = i;
}

public void rearrange(Numbers numbers){
    int index = a.size()-1;
    a.remove(index);
    a.add(index, numbers);

    if(a.size() >= 2){
        mController.setBool(true);
    }

}
public String performCalculation(){
    Numbers num1, num2;
    if(num != null){
        num1 = new Numbers(num.toString());
        num2 = a.get(a.size()-1);
    }else{
        num1 = a.get(0);
        num2 = a.get(1);
    }
   switch(mOperation){
       case Constants.ADD:
           num = add(num1, num2);
           break;
   }
    answer = num.toString();

    //reset values
    reset();

    return answer;
}

    public void reset(){
    answer = "";
    a = null;
    mOperation = null;
}

    private void init(){
    a = new ArrayList<>();
}

    private Number add(Numbers num1, Numbers num2) {
        if(num1.getType().equals("Integer") && num2.getType().equals("Integer"))
            return num1.getNumber().intValue() + num2.getNumber().intValue();
        else if(num1.getType().equals("Integer") && num2.getType().equals("Double"))
            return num1.getNumber().intValue() + num2.getNumber().doubleValue();
        else if(num1.getType().equals("Double") && num2.getType().equals("Integer"))
            return num1.getNumber().doubleValue() + num2.getNumber().intValue();
        else
            return num1.getNumber().doubleValue() + num2.getNumber().doubleValue();
    }

    private Number subtract(Numbers num1, Numbers num2) {
        if(num1.getType().equals("Integer") && num2.getType().equals("Integer"))
            return num1.getNumber().intValue() - num2.getNumber().intValue();
        else if(num1.getType().equals("Integer") && num2.getType().equals("Double"))
            return num1.getNumber().intValue() - num2.getNumber().doubleValue();
        else if(num1.getType().equals("Double") && num2.getType().equals("Integer"))
            return num1.getNumber().doubleValue() - num2.getNumber().intValue();
        else
            return num1.getNumber().doubleValue() - num2.getNumber().doubleValue();
    }
}
