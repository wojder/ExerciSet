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

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    @Bind(R.id.first_digit_entry)
    MaterialAutoCompleteTextView firstDigitEntry;
    @Bind(R.id.second_digit_entry)
    MaterialAutoCompleteTextView secondDigitEntry;
    @Bind(R.id.button_add)
    Button buttonAddition;
    @Bind(R.id.button_subtract)
    Button buttonSubstraction;
    @Bind(R.id.button_divide)
    Button buttonDivision;
    @Bind(R.id.button_multiply)
    Button buttonMultiplication;
    @Bind(R.id.clear_button)
    Button buttonClear;
    @Bind(R.id.calc_image)
    ImageView calculatorImg;
    @Bind(R.id.result)
    TextView result;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View calculatorView = inflater.inflate(R.layout.fragment_calculator, container, false);
        ButterKnife.bind(this, calculatorView);

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
                    result.setText(String.format(Locale.ENGLISH, "%1$, .2f", finalResult));
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
                    result.setText(String.format(Locale.ENGLISH, "%1$, .2f", finalResult));
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
                    result.setText(String.format(Locale.ENGLISH, "%1$, .2f", finalResult));
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
                    result.setText(String.format(Locale.ENGLISH, "%1$, .2f", finalResult));
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