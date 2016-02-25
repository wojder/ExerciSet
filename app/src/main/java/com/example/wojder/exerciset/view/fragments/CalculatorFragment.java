package com.example.wojder.exerciset.view.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wojder.exerciset.R;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {
    private MaterialAutoCompleteTextView firstDigitEntry;
    private MaterialAutoCompleteTextView secondDigitEntry;
    private Button buttonAddition;
    private Button buttonSubstraction;
    private Button buttonDivision;
    private Button buttonMultiplication;
    private Button buttonClear;
    private ImageView calculatorImg;
    private TextView result;

    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View calculatorView = inflater.inflate(R.layout.fragment_calculator, container, false);

        firstDigitEntry = (MaterialAutoCompleteTextView) calculatorView.findViewById(R.id.first_digit_entry);
        secondDigitEntry = (MaterialAutoCompleteTextView) calculatorView.findViewById(R.id.second_digit_entry);
        buttonAddition = (Button) calculatorView.findViewById(R.id.button_add);
        buttonSubstraction = (Button) calculatorView.findViewById(R.id.button_subtract);
        buttonDivision = (Button) calculatorView.findViewById(R.id.button_divide);
        buttonMultiplication = (Button) calculatorView.findViewById(R.id.button_multiply);
        buttonClear = (Button) calculatorView.findViewById(R.id.clear_button);
        result = (TextView) calculatorView.findViewById(R.id.result);
        calculatorImg = (ImageView) calculatorView.findViewById(R.id.calc_image);
        String internetImageSource = "http://icons.iconarchive.com/icons/martz90/circle/512/calculator-icon.png";

        Glide
                .with(calculatorImg.getContext())
                .load(internetImageSource)
                .centerCrop()
                .into(calculatorImg);

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (firstDigitEntry.getText().length() > 0 && secondDigitEntry.getText().length() > 0) {

                    final double firstOperand = Double.parseDouble(firstDigitEntry.getText().toString());
                    final double secondOperand = Double.parseDouble(secondDigitEntry.getText().toString());

                    double finalResult = firstOperand + secondOperand;
                    result.setText(Double.toString(finalResult));
                } else {
                    Snackbar.make(v, R.string.valid_number, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        buttonSubstraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstDigitEntry.getText().length() > 0 && secondDigitEntry.getText().length() > 0) {

                    final double firstOperand = Double.parseDouble(firstDigitEntry.getText().toString());
                    final double secondOperand = Double.parseDouble(secondDigitEntry.getText().toString());

                    double finalResult = firstOperand - secondOperand;
                    result.setText(Double.toString(finalResult));
                } else {
                    Snackbar.make(v, R.string.valid_number, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstDigitEntry.getText().length() > 0 && secondDigitEntry.getText().length() > 0) {
                    double firstOperand = Double.parseDouble(firstDigitEntry.getText().toString());
                    double secondOperand = Double.parseDouble(secondDigitEntry.getText().toString());

                    double finalResult = firstOperand / secondOperand;
                    result.setText(Double.toString(finalResult));
                } else {
                    Snackbar.make(v, R.string.valid_number, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstDigitEntry.getText().length() > 0 && secondDigitEntry.getText().length() > 0) {
                    double firstOperand = Double.parseDouble(firstDigitEntry.getText().toString());
                    double secondOperand = Double.parseDouble(secondDigitEntry.getText().toString());

                    double finalResult = firstOperand * secondOperand;
                    result.setText(Double.toString(finalResult));
                } else {
                    Snackbar.make(v, R.string.valid_number, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstDigitEntry.setText("");
                secondDigitEntry.setText("");
                result.setText("0.00");
                firstDigitEntry.requestFocus();
            }
        });
        return calculatorView;
    }
}
