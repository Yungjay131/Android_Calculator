package com.slyworks.calculator;

public class Calculations {

    public Number add(Numbers num1, Numbers num2) {
        if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).intValue() + num2.getNumber(num2).intValue();
        else if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Double"))
            return num1.getNumber(num1).intValue() + num2.getNumber(num2).doubleValue();
        else if(num1.getType(num1).equals("Double") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).doubleValue() + num2.getNumber(num2).intValue();
        else
            return num1.getNumber(num1).doubleValue() + num2.getNumber(num2).doubleValue();
    }


    public Number subtract(Numbers num1, Numbers num2) {
        if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).intValue() - num2.getNumber(num2).intValue();
        else if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Double"))
            return num1.getNumber(num1).intValue() - num2.getNumber(num2).doubleValue();
        else if(num1.getType(num1).equals("Double") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).doubleValue() - num2.getNumber(num2).intValue();
        else
            return num1.getNumber(num1).doubleValue() - num2.getNumber(num2).doubleValue();
    }

    public Number divide(Numbers num1, Numbers num2) {
        if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).intValue() / num2.getNumber(num2).intValue();
        else if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Double"))
            return num1.getNumber(num1).intValue() / num2.getNumber(num2).doubleValue();
        else if(num1.getType(num1).equals("Double") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).doubleValue() / num2.getNumber(num2).intValue();
        else
            return num1.getNumber(num1).doubleValue() / num2.getNumber(num2).doubleValue();
    }


    public  Number multiply(Numbers num1, Numbers num2) {
        if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).intValue() * num2.getNumber(num2).intValue();
        else if(num1.getType(num1).equals("Integer") && num2.getType(num2).equals("Double"))
            return num1.getNumber(num1).intValue() * num2.getNumber(num2).doubleValue();
        else if(num1.getType(num1).equals("Double") && num2.getType(num2).equals("Integer"))
            return num1.getNumber(num1).doubleValue() * num2.getNumber(num2).intValue();
        else
            return num1.getNumber(num1).doubleValue() * num2.getNumber(num2).doubleValue();
    }



    //Methods for trigonometry
    private double sin(Integer integer) {
        return Math.sin(Double.valueOf(integer));
    }

    private double cos(Integer integer) {
        return Math.cos(Double.valueOf(integer));
    }

    private double tan(Integer integer) {
        return Math.tan(Double.valueOf(integer));
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
