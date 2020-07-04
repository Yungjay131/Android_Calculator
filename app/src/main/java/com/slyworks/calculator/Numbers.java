package com.slyworks.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Numbers {
    //class to represent numbers entered from the calculator
    private ArrayList<Integer> mNumbersInt = new ArrayList<>();
    private ArrayList<Double> mNumbersDouble = new ArrayList<>();

    private  Double mDouble = 0.0;
    private Integer mInteger = 0;
    private  String type = "";
    private Number number;

public Numbers(String num) {
    if(num.contains(".")) {
        this.number = Double.valueOf(num);
        this.type = "Double";
    } else{
        this.number = Integer.valueOf(num);
        this.type  = "Integer";
    }
}

  public Number getNumber(Numbers number){
    return number.number;
  }

  public String getType(Numbers number){
    return number.type;
  }

}
