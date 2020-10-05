package com.slyworks.calculator;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joshua Sylvanus, 7:02 AM, 10/2/2020.
 */
public class Controller2 {
    //region Vars
    OnValueChangedListener mListener;
    private  static Controller2 instance;
    private StringBuilder mTemp;
    private ArrayList<Numbers> a;
    private boolean mIsStillASingleOperation = true;
    private Integer mOperation;
    private Map<String, Integer> mMap = new HashMap<>();

    private Calculations2 mCalc;
    private boolean mIsNowValidOp;
    //endregion

    private Controller2(OnValueChangedListener listener){
        mListener = listener;
        mCalc = new Calculations2();
    }

    public static Controller2 getInstance(OnValueChangedListener listener){
        if(instance == null){
           instance = new Controller2(listener);
        }
        return instance;
    }

    //only to be called once i'm sure this class has been instantiated
    public static Controller2 getInstance(){
        return instance;
    }
    private void setMapValues(){
        mMap.put("+", Constants.ADD);
        mMap.put("-",Constants.SUBTRACT);
        mMap.put("x",Constants.MULTIPLY);
        mMap.put("/",Constants.DIVISION);
        mMap.put("sin",Constants.SIN);
        mMap.put("cos",Constants.COS);
        mMap.put("tan",Constants.TAN);
        mMap.put("log",Constants.LOG);
        //mMap.put("ln",Constants.ln);
        mMap.put("",Constants.SQUAREROOT);//TODO:find key for squareroot for button and here
        //mMap.put("!",Constants.);
        mMap.put("^",Constants.RAISE_TO_POWER);
        mMap.put("pi",Constants.PI);
        mMap.put("e",Constants.EXPONENTIAL);
    }
    public void check(@Nullable String s, @Nullable Integer i){
        if(i != null){
            switch (i){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    performNumberButtonCheck(i);
                default:
                    break;
            }
        }else if(s != null){
                    performOperandCheck(s);
        }

    }

    private void performOperandCheck(String s) {
        if(mOperation != null){
            return;
        }
        if(s.equals(".") && mTemp.toString().contains(".")){
            return;
        }
        //if it passed all checks get the operation eg "+"
        getOperation(s);
    }

    private void performNumberButtonCheck(Integer i) {
        //TODO:do some checks here
        append(String.valueOf(i));
    }

    public void append(String buttonPressed){
        if(mTemp.toString() != ""){
            //meaning a number has been pressed
            mCalc.rearrange(new Numbers(mTemp.toString()+buttonPressed) );
        }
        mTemp.append(buttonPressed);
        displayToTextView(Constants.APPEND, null);

        if(mIsNowValidOp){//i.e if there a now 2 Numbers in the queue
            calculationQuery();
        }

    }
    public void setBool(boolean aBoolean){
        mIsNowValidOp = aBoolean;
    }
    public void getOperation(String operation){
        //TODO:after performing check, get the operand
        saveToList();
        mOperation = mMap.get(operation);

        //adding to queue of operations
        mCalc.insertOperation(mOperation);

        displayToTextView(Constants.APPEND, operation);
    }
    public void saveToList(){
        Numbers numbers = new Numbers(mTemp.toString());
        mCalc.insertToQueue(numbers);
        reset();
    }

    //TODO:should be called once the equal button is clicked
    //TODO:should be called once the numbers are up to 2 or a unary operator was pressed
    //TODO:should be called from onTextChanged() in the MainActivity(), would be necessary to find a way to add and replace the number
    //TODO:once a value is added
    public void calculationQuery(){
        String ans = mCalc.performCalculation();

        //TODO:revise use of enums
        displayToTextView( Constants.SET , ans);
    }

    public void removeLastDigit(){

    }
    public void clearAll(){

    }
    public void saveAnswer(){

    }
    public void displayToTextView( Integer  op, @Nullable String value){
        mListener.onChanged(op, value);
    }

    private void reset(){
        mTemp = null;
        //a = null;
        mOperation = null;
        mIsStillASingleOperation = false;
        mIsNowValidOp = false;
    }
    private void initValues(){
        mTemp = new StringBuilder();
        //a = new ArrayList<>();
        mIsStillASingleOperation = true;
    }
    //TODO:implement the calculations such that if its past a certain number of operations use Threading
    //TODO:or could be avoided using running the operations as they come up
}
