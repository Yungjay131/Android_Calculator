package com.slyworks.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Numbers {
    //region initialisation code
    //class to represent numbers entered from the calculator
    private  Double mDouble = 0.0;
    private Integer mInteger = 0;
    private  String type = "";
    private Number number;

    public static final int NO_OPERATION= 0 ;
    public static final  int ADD = 1;
    public static final  int SUBTRACT = 2;
    public static final int MULTIPLY = 3;
    public static final int DIVIDE = 4;
    public static final int SIN = 5;
    public static final int COS = 6;
    public static final int TAN = 7;


    private int operation;
    private boolean isThereAnotherNum;
//endregion

public Numbers(String num, int operation,boolean isThereAnotherNum) {
    if(num.contains(".")) {
        this.number = Double.valueOf(num);
        this.type = "Double";
    } else{
        this.number = Integer.valueOf(num);
        this.type  = "Integer";
    }
    this.operation = operation;
    this.isThereAnotherNum = isThereAnotherNum;
}

  public Number getNumber(){
    return number;
  }

  public String getType(){
    return type;
  }
  public int getOperation(){
    return operation;
  }
  public boolean getOtherNumber(){
    return isThereAnotherNum;
  }

}
