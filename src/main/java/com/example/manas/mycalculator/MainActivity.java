package com.example.manas.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);

//        display.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(getString(R.string.display).equals(display.getText().toString()))
//                    display.setText("");
//            }
//        });
        display.setShowSoftInputOnFocus(false);
    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int currentPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,currentPos);
        String rightStr = oldStr.substring(currentPos);
//        if(getString(R.string.display).equals(display.getText().toString()))
//        { display.setText(strToAdd);
//        display.setSelection(currentPos + 1);
//    }
//        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(currentPos + 1);
//        }
    }
    public void zeroBTN(View view){
       updateText("0");
    }
    public void oneBTN(View view){
        updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void parenthesisBTN(View view){

        int cursorpos = display.getSelectionStart();
        int openpar = 0;
        int closepar = 0;
        int textlen = display.getText().length();

        for(int i=0;i<cursorpos;i++)
        {
            if(display.getText().toString().substring(i,i+1).equals("("))
                openpar += 1;
            if(display.getText().toString().substring(i,i+1).equals(")"))
                closepar += 1;
        }

        if(openpar == closepar || display.getText().toString().substring(textlen-1,textlen).equals("("))
          {  updateText("(");
        display.setSelection(cursorpos+1);}

        else if(closepar < openpar && !display.getText().toString().substring(textlen-1,textlen).equals("("))
        {  updateText(")");
            display.setSelection(cursorpos+1);}
    }
    public void exponentBTN(View view){
        updateText("^");
    }
    public void divideBTN(View view){
        updateText("/");
    }
    public void multiplyBTN(View view){
        updateText("*");
    }
    public void addBTN(View view){
        updateText("+");
    }
    public void subtractBTN(View view){
        updateText("-");
    }
    public void plusMinusBTN(View view){
        updateText("-");
    }
    public void equalBTN(View view){

        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);

        String res = String.valueOf(exp.calculate());

        display.setText(res);
        display.setSelection(res.length());
    }
    public void backspaceBTN(View view){

        int cursorpos = display.getSelectionStart();
        int texlen = display.getText().length();

        if(cursorpos != 0 && texlen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos-1,cursorpos,"");
            display.setText(selection);
            display.setSelection(cursorpos - 1);
        }
    }
    public void pointBTN(View view){
        updateText(".");
    }

}