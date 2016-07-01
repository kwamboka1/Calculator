 package com.mildred.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    //int result;
    //TextView tvResult;
    //Global Variable
    private EditText etFirstNumber;
    private EditText etSecondNumber;
    private int operationType;
    private int result;
    private TextView tvResult, stNumberOne, StNumberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Declare and Initialize

        EditText etFirstNumber = (EditText) findViewById(R.id.etnumberone);
        EditText etSecondNumber = (EditText) findViewById(R.id.etnumber2);
        tvResult = (TextView) findViewById(R.id.tvresult);

        Button btnCalculate = (Button) findViewById(R.id.btncalculate);

        RadioButton rbMultiplication = (RadioButton) findViewById(R.id.rbmultiplication);
        rbMultiplication.setOnCheckedChangeListener(this);


        RadioButton rbAddition = (RadioButton) findViewById(R.id.rbaddition);
        rbAddition.setOnCheckedChangeListener(this);

        RadioButton rbSubtraction = (RadioButton) findViewById(R.id.rbsubtraction);
        rbSubtraction.setOnCheckedChangeListener(this);


        String strFirstNumber = etFirstNumber.getText().toString();
        String strSecondNumber = etSecondNumber.getText().toString();
        //Convert String to integer
        int numberOne = Integer.parseInt(strFirstNumber);
        int numberTwo = Integer.parseInt(strSecondNumber);
        result = numberOne + numberTwo;
        btnCalculate.setOnClickListener(this);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.rbaddition:

                operationType = 1;
                break;
            case R.id.rbmultiplication:

                operationType = 2;
                break;
            case R.id.rbsubtraction:

                operationType = 3;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btncalculate) {
            //Get the String
            String FirstNumber = etFirstNumber.getText().toString();
            String SecondNumber = etSecondNumber.getText().toString();

            //Convert
            int NumberOne = Integer.parseInt(FirstNumber);
            int NumberTwo = Integer.parseInt(SecondNumber);
            if (operationType == 1) {
                //perform Addition and display result
                int result = addition(NumberOne, NumberTwo);
                tvResult.setText("Answer is:" + result);
            }

            if (operationType == 2) {
                //perform Subtraction and display result
                int result = subtraction(NumberOne, NumberTwo);
                tvResult.setText("Answer is:" + result);
            }

            if (operationType == 3) {
                //perform Multiplication and display result
                int result = multiplication(NumberOne, NumberTwo);
                tvResult.setText("Answer is:" + result);
            }
        }

    }

    public static int addition(int FirstNumber, int SecondNumber) {
        return FirstNumber + SecondNumber;
    }

    public static int subtraction(int FirstNumber, int SecondNumber) {
        return FirstNumber - SecondNumber;
    }

    public static int multiplication(int FirstNumber, int SecondNumber) {
        return FirstNumber * SecondNumber;
    }
}

