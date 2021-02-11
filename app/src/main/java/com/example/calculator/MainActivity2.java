package com.example.calculator;
import android.os.Build;
import android.os.Bundle;
import org.mariuszgromada.math.mxparser.*;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    //    Insilazation
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        hide status bar
        Objects.requireNonNull(getSupportActionBar()).hide();

//        ID Insilazation
        display = findViewById(R.id.input);

//       Input ShowFocus
        display.setShowSoftInputOnFocus(false);

//        click setOnClickListener Empty
        display.setOnClickListener(v -> {
            if (getString(R.string.display).equals(display.getText().toString())) {
                display.setText("");
            }
        });
    }

    //    display
    public void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

//    button Setting

    public void zeroBTM(View view) {
        updateText("0");
    }

    public void oneBTM(View view) {
        updateText("1");
    }

    public void twoBTM(View view) {
        updateText("2");
    }

    public void threeBTM(View view) {
        updateText("3");
    }

    public void fourBTM(View view) {
        updateText("4");
    }

    public void fiveBTM(View view) {
        updateText("5");
    }

    public void sixBTM(View view) {
        updateText("6");
    }

    public void sevenBTM(View view) {
        updateText("7");
    }

    public void eightBTM(View view) {
        updateText("8");
    }

    public void nineBTM(View view) {
        updateText("9");
    }

    public void clearBTM(View view) {
        display.setText("");
    }

    public void bracketBTN(View view) {
        int c = display.getSelectionStart();
        int o = 0;
        int close = 0;
        int t = display.getText().length();

        for (int i = 0; i < c; i++) {
            if (display.getText().toString().startsWith("(", i)) {
                o += 1;
            }
            if (display.getText().toString().startsWith(")", i)) {
                close += 1;
            }
        }
        if (o == close || display.getText().toString().startsWith("(", t - 1)) {
            updateText("(");
        } else if (close < o && !display.getText().toString().startsWith("(", t - 1)) {
            updateText(")");
        }
        display.setSelection(close + 1);
    }

    public void dividedBTN(View view) {
        updateText("÷");
    }

    public void perBTN(View view) {
        updateText("%");
    }

    public void intoBTN(View view) {
        updateText("x");
    }

    public void subtractionBAN(View view) {
        updateText("-");
    }

    public void plusBTN(View view) {
        updateText("+");
    }

    public void equalBTN(View view) {
        String u = display.getText().toString();

        u = u.replaceAll("÷","/");
        u = u.replaceAll("x","*");

        Expression ex = new Expression(u);
        String res = String.valueOf(ex.calculate());
        display.setText(res);
        display.setSelection(res.length());
    }

    public void dotBTN(View view) {
        updateText(".");
    }

    public void plusmineBTN(View view) {
        updateText("-");
    }

    public void backS(View view) {
        int c = display.getSelectionStart();
        int t = display.getText().length();

        if (c != 0 && t != 0) {
            SpannableStringBuilder s = (SpannableStringBuilder) display.getText();
            s.replace(c - 1, c, "");
            display.setText(s);
            display.setSelection(c - 1);
        }
    }
}