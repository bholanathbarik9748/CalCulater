package com.example.calculater;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    //    variable Initialization
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonC, buttonEqual, percentBTN, plusminBTN, dotBTN;
    float mValueOne, mValueTwo;
    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;
    private EditText crunchifyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//id

        button0 = (Button) findViewById(R.id.zeroBTN);
        button1 = (Button) findViewById(R.id.oneBTN);
        button2 = (Button) findViewById(R.id.twoBTN);
        button3 = (Button) findViewById(R.id.ThreeBTN);
        button4 = (Button) findViewById(R.id.fourBTN);
        button5 = (Button) findViewById(R.id.fiveBTN);
        button6 = (Button) findViewById(R.id.sixBTN);
        button7 = (Button) findViewById(R.id.sevenBTN);
        button8 = (Button) findViewById(R.id.EightBTN);
        button9 = (Button) findViewById(R.id.nineBTN);
        buttonAdd = (Button) findViewById(R.id.plusBTN);
        buttonSub = (Button) findViewById(R.id.substractionBTN);
        buttonMul = (Button) findViewById(R.id.intoBTN);
        buttonDivision = (Button) findViewById(R.id.dividedBTN);
        buttonC = (Button) findViewById(R.id.clearBTN);
        buttonEqual = (Button) findViewById(R.id.eualBTN);
        percentBTN = (Button) findViewById(R.id.percentBTN);
        dotBTN = (Button) findViewById(R.id.dotBTN);
        plusminBTN = (Button) findViewById(R.id.plusminBTN);
        crunchifyEditText = (EditText) findViewById(R.id.input);

//        NUMBER Code

//        0 Button code
        button0.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "0"));

//        1 Button code
        button1.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "1"));

//        2 Button code
        button2.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "2"));

//        3 Button code
        button3.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "3"));

//        4 Button code
        button4.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "4"));

//        5 Button code
        button5.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "5"));

//        6 Button code
        button6.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "6"));

//        7 Button code
        button7.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "7"));

//        8 Button code
        button8.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "8"));

//        9 Button code
        button9.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "9"));

//        % Button code
        percentBTN.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "%"));

//        ÷ Button code
        buttonDivision.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "÷"));

//        X Button code
        buttonMul.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "X"));

//         - Button code
        buttonSub.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "-"));

//        + Button code
        buttonAdd.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "-"));

//        . Button code
        dotBTN.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "."));

//        +/- Button code
        plusminBTN.setOnClickListener(v -> crunchifyEditText.setText(crunchifyEditText.getText() + "(-"));


//        Operation CODE

//        + Operation code
        buttonAdd.setOnClickListener(v -> {

            if (crunchifyEditText == null) {
                crunchifyEditText.setText("");
            } else {
                mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
                crunchifyAddition = true;
                crunchifyEditText.setText("+");
            }
        });


//         - Operation code
        buttonSub.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            mSubtract = true;
            crunchifyEditText.setText("-");
        });


//        X Operation code
        buttonMul.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            crunchifyMultiplication = true;
            crunchifyEditText.setText("X");
        });


//         per Operation code
        percentBTN.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            crunchifyDivision = true;
            crunchifyEditText.setText("%");
        });


//        % Operation code
        buttonDivision.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
            crunchifyDivision = true;
            crunchifyEditText.setText("÷");
        });


//        clear
        buttonC.setOnClickListener(v -> crunchifyEditText.setText(""));


//      Equal
        buttonEqual.setOnClickListener(v -> {
            mValueTwo = Float.parseFloat(crunchifyEditText.getText() + "");

            if (crunchifyAddition == true) {
                crunchifyEditText.setText(mValueOne + mValueTwo + "");
                crunchifyAddition = false;
            }

            if (mSubtract == true) {
                crunchifyEditText.setText(mValueOne - mValueTwo + "");
                mSubtract = false;
            }

            if (crunchifyMultiplication == true) {
                crunchifyEditText.setText(mValueOne * mValueTwo + "");
                crunchifyMultiplication = false;
            }

            if (crunchifyDivision == true) {
                crunchifyEditText.setText(mValueOne / mValueTwo + "");
                crunchifyDivision = false;
            }
        });

    }


    //backspace
    public void backS(View view) {
        int c = crunchifyEditText.getSelectionStart();
        int t = crunchifyEditText.getText().length();

        if (c != 0 && t != 0) {
            SpannableStringBuilder s = (SpannableStringBuilder) crunchifyEditText.getText();
            s.replace(c - 1, c, "");
            crunchifyEditText.setText(s);
            crunchifyEditText.setSelection(c - 1);
        }
    }

    //    bracket
    public void bracketBTN(View view) {
        int c = crunchifyEditText.getSelectionStart();
        int o = 0;
        int close = 0;
        int t = crunchifyEditText.getText().length();

        for (int i = 0; i < c; i++) {
            if (crunchifyEditText.getText().toString().startsWith("(", i)) {
                o += 1;
            }
            if (crunchifyEditText.getText().toString().startsWith(")", i)) {
                close += 1;
            }
        }
        if (o == close || crunchifyEditText.getText().toString().startsWith("(", t - 1)) {
            updateText("(");
        } else if (close < o && !crunchifyEditText.getText().toString().startsWith("(", t - 1)) {
            updateText(")");
        }
        crunchifyEditText.setSelection(close + 1);
    }

    private void updateText(String s) {
        String oldStr = crunchifyEditText.getText().toString();
        int cursorPos = crunchifyEditText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if ("".equals(crunchifyEditText.getText().toString())) {
            crunchifyEditText.setText(s);
        } else {
            crunchifyEditText.setText(String.format("%s%s%s", leftStr, s, rightStr));
            crunchifyEditText.setSelection(cursorPos + 1);
        }

    }
}