package com.slyworks.calculator;

import java.util.ArrayList;

/**
 * Created by Joshua Sylvanus, 6:58 AM, 10/2/2020.
 */
public class Calculations {
    //region Vars
    String answer = "";
    Number num;
    ArrayList<Numbers> a = new ArrayList<>();
    static Integer mOperation = null;
    private Controller mController = Controller.getInstance();
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
    /*
    if(a.size() >= 2){
        mController.setBool(true);
    }
     */
}
public void insertOperation(Integer i){
    mOperation = i;
}

public void rearrange(Numbers numbers){
    int index = a.size()-1;
    a.remove(index);
    a.add(index, numbers);

    /*
    if(a.size() >= 2){
        mController.setBool(true);
    }
     */
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
       case Constants.SUBTRACT:
           num = subtract(num1, num2);
           break;
       case Constants.MULTIPLY:
           num = multiply(num1, num2);
           break;
       case Constants.DIVIDE:
           num = divide(num1,num2);
           break;
       case Constants.SIN:
           num = sin(num1);
           break;
       case Constants.COS:
           num = cos(num1);
           break;
       case Constants.TAN:
           num = tan(num1);
           break;
      // case Constants.:
      // case Constants.:
     //  case Constants.:
     //  case Constants.:
     //  case Constants.:
      // case Constants.:
       //    break;
   }
    answer = String.valueOf(num);

    //reset values
    reset();

    return answer;
}

    public void reset(){
    //answer = "";
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

    public Number divide(Numbers num1, Numbers num2) {
        if(num1.getType().equals("Integer") && num2.getType().equals("Integer"))
            return num1.getNumber().intValue() / num2.getNumber().intValue();
        else if(num1.getType().equals("Integer") && num2.getType().equals("Double"))
            return num1.getNumber().intValue() / num2.getNumber().doubleValue();
        else if(num1.getType().equals("Double") && num2.getType().equals("Integer"))
            return num1.getNumber().doubleValue() / num2.getNumber().intValue();
        else
            return num1.getNumber().doubleValue() / num2.getNumber().doubleValue();
    }


    public Number multiply(Numbers num1, Numbers num2) {
        if(num1.getType().equals("Integer") && num2.getType().equals("Integer"))
            return num1.getNumber().intValue() * num2.getNumber().intValue();
        else if(num1.getType().equals("Integer") && num2.getType().equals("Double"))
            return num1.getNumber().intValue() * num2.getNumber().doubleValue();
        else if(num1.getType().equals("Double") && num2.getType().equals("Integer"))
            return num1.getNumber().doubleValue() * num2.getNumber().intValue();
        else
            return num1.getNumber().doubleValue() * num2.getNumber().doubleValue();
    }



    //Methods for trigonometry
    public Number sin(Numbers num) {
        return Math.sin(num.getNumber().doubleValue());
    }
    public Number cos(Numbers num) {
        return Math.cos(num.getNumber().doubleValue());
    }
    public Number tan(Numbers num) {
        return Math.tan(num.getNumber().doubleValue());
    }



    private double log(Numbers num) {
        return Math.log((double)num.getNumber());
    }

    private double squareRoot(Numbers num) {
        return Math.sqrt((double)num.getNumber());
    }

    private double raiseToPower(Numbers num, Numbers num1) {
        return Math.pow((double)num.getNumber(), (double)num.getNumber());
    }


    private double exponential(Numbers num) {
        return Math.getExponent((double)num.getNumber());
    }

    private double ln(Numbers num) {
        return Math.log10((double)num.getNumber());

    }

    private int factorial(Numbers num) {
        return (int)num.getNumber();
    }

}
