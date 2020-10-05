package com.slyworks.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculations {
    public String performCalc(ArrayList<ArrayList<Numbers>> numbersList){
        int length = numbersList.size();
        for (ArrayList<Numbers> i: numbersList) {
            performCalculations(i);
        }
        return answer;
    }
    public  String performCalculations(List<Numbers> numbersList){
        //TODO:implement with Streams
        Number answer = 0;
        Numbers sum = null;
        Numbers answerTemp = null;
        for(int i=0;i<numbersList.size();i++){
                switch(numbersList.get(i).getOperation()){
                    case Numbers.NO_OPERATION:
                        continue;
                    case Numbers.ADD:
                        if(i==0){
                            answer  =  add(numbersList.get(i),numbersList.get(i+1));
                        }else{
                            answerTemp = new Numbers(answer.toString(),Numbers.NO_OPERATION,false);
                            answer  = add(answerTemp,numbersList.get(i+1) );
                        }
                        break;
                    case Numbers.SIN:
                         if(i == 0){
                             answer = sin(numbersList.get(i));
                         }else{
                             answerTemp = new Numbers(answer.toString());
                             Numbers answerSin = new Numbers(sin(numbersList.get(i)).toString(),Numbers.NO_OPERATION, false);
                             answer = multiply(answerTemp, answerSin);
                             break;
                         }
                    case Numbers.COS:
                        if(i == 0){
                            answer = sin(numbersList.get(i));
                        }else{
                            answerTemp = new Numbers(answer.toString(),Numbers.NO_OPERATION,false);
                            Numbers answerSin = new Numbers(cos(numbersList.get(i)).toString(),Numbers.NO_OPERATION, false);
                            answer = multiply(answerTemp, answerSin);
                            break;
                        }
                    case Numbers.TAN:
                        if(i == 0){
                            answer = sin(numbersList.get(i));
                        }else{
                            answerTemp = new Numbers(answer.toString(),Numbers.NO_OPERATION,false);
                            Numbers answerSin = new Numbers(tan(numbersList.get(i)).toString(),Numbers.NO_OPERATION, false);
                            answer = multiply(answerTemp, answerSin);
                            break;
                        }
            }
            //sum = null;
            answerTemp = null;
        }

        return answer.toString();
        }

    public Number add(Numbers num1, Numbers num2) {
        if(num1.getType().equals("Integer") && num2.getType().equals("Integer"))
            return num1.getNumber().intValue() + num2.getNumber().intValue();
        else if(num1.getType().equals("Integer") && num2.getType().equals("Double"))
            return num1.getNumber().intValue() + num2.getNumber().doubleValue();
        else if(num1.getType().equals("Double") && num2.getType().equals("Integer"))
            return num1.getNumber().doubleValue() + num2.getNumber().intValue();
        else
            return num1.getNumber().doubleValue() + num2.getNumber().doubleValue();
    }


    public Number subtract(Numbers num1, Numbers num2) {
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



    private double log(Integer integer) {
        return Math.log(Double.valueOf(integer));
    }

    private double squareRoot(Integer integer) {
        return Math.sqrt(Double.valueOf(integer));
    }

    private double raiseToPower(Integer integer, Integer integer1) {
        return Math.pow(Double.valueOf(integer), Double.valueOf(integer1));
    }


    private double exponential(Integer integer) {
        return Math.getExponent(Double.valueOf(integer));
    }

    private double ln(Integer integer) {
        return Math.log10(Double.valueOf(integer));

    }

    private int factorial(Integer integer) {

        return integer;
    }

}
