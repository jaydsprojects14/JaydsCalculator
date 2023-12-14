package com.example.mycalculatorapp;

import static java.lang.Short.compare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Integer[] subeq;
   String eq_to_calculate,output;
    TextView resultTv,solutionTv;
    Button btnClear,btnBracOpen,btnBracClose;
    Button btnDivide,btnMultiply,btnAdd,btnSub,btnEqual;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnAc,btnDec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign id to TextViews.
        resultTv=findViewById(R.id.resultequation);
        solutionTv=findViewById(R.id.inputequation);

        //functional buttons
        assignId(btnClear,R.id.clrbtn);
        assignId(btnBracOpen,R.id.openbracket);
        assignId(btnBracClose,R.id.closebracket);
        assignId(btnAc,R.id.onBtn);
        assignId(btnDec,R.id.decibtn);

        //operator buttons
        assignId(btnDivide,R.id.opdiv);
        assignId(btnMultiply,R.id.opmul);
        assignId(btnAdd,R.id.opadd);
        assignId(btnSub,R.id.opsub);

        //numeric buttons
        assignId(btnEqual,R.id.equalsTo);
        assignId(btn0,R.id.num0);
        assignId(btn1,R.id.num1);
        assignId(btn2,R.id.num2);
        assignId(btn3,R.id.num3);
        assignId(btn4,R.id.num4);
        assignId(btn5,R.id.num5);
        assignId(btn6,R.id.num6);
        assignId(btn7,R.id.num7);
        assignId(btn8,R.id.num8);
        assignId(btn9,R.id.num9);

    }
    //to Assign id to the buttons
    void assignId(Button btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button btnclicked=(Button) view;
        String btnText=btnclicked.getText().toString();

        //set the text of button clicked on screen
        //solutionTv.setText(btnText);

        //concatenate the strings to get an equation that is to be calculated
        eq_to_calculate=solutionTv.getText().toString();


        if(btnText.equals("AC")){
            eq_to_calculate="";
            output="";
            solutionTv.setText("");
            resultTv.setText("");
            return;
        }
        else if(btnText.equals("=")){
            solve();
            return;
           // resultTv.setText(solutionTv.getText());

        }
        else if(btnText.equals("Clear")){
            eq_to_calculate=eq_to_calculate.substring(0,eq_to_calculate.length()-1);

        }
        else if(btnText.equals("+")||btnText.equals("-")||btnText.equals("*")||btnText.equals("/")){
            eq_to_calculate=eq_to_calculate+btnText;
            solve();
        }
        else {
            eq_to_calculate = eq_to_calculate + btnText;
        }
        //set the concatenated string on screen
        solutionTv.setText(eq_to_calculate);

    }

    private void solve() {
        if(eq_to_calculate.split("\\+").length == 2){
            String numbers[] = eq_to_calculate.split("\\+");
            try{
                double d=Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                resultTv.setText(output);
                eq_to_calculate =  d + "";
            }
            catch(Exception e){
                resultTv.setError(e.getMessage().toString());
            }
        }
    }


}