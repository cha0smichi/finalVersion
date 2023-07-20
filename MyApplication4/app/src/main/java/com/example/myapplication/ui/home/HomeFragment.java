package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class HomeFragment extends Fragment {
    private EditText numberField;
    private Button calculateButton;
    private TextView resultLabel;
    private TextView resultLabel2;
    private TextView resultLabel3;
    private TextView resultLabel4;
    private double resultLabel5 = 0.0; // New variable of type double for resultlabel5
    private EditText Celsius;
    private EditText editText4; // New EditText for the sum
    private EditText editText6; // New EditText for the sum
    private TextView textView16;
    private Button button3; // Corrected variable name
    private boolean isTextView16Visible = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        numberField = rootView.findViewById(R.id.editText);
        calculateButton = rootView.findViewById(R.id.calculateButton);
        resultLabel = rootView.findViewById(R.id.resultlabel);
        resultLabel2 = rootView.findViewById(R.id.resultlabel2);
        resultLabel3 = rootView.findViewById(R.id.resultlabel3);
        resultLabel4 = rootView.findViewById(R.id.resultlabel4);
        Celsius = rootView.findViewById(R.id.editText3);
        editText4 = rootView.findViewById(R.id.editText4); // Initialize the new EditText
        editText6 = rootView.findViewById(R.id.editText6); // Initialize the new EditText
        textView16 = rootView.findViewById(R.id.textView16);
        button3 = rootView.findViewById(R.id.button3);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResultLabel5();
                calculateResult();
                updateTime();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTextView16Visible = !isTextView16Visible;
                updateTextView16Visibility();
            }
        });

        updateTextView16Visibility(); // Ensure initial visibility is set based on isTextView16Visible

        return rootView;
    }

    private void calculateResultLabel5() {
        // Implementation remains the same...
    }

    private void calculateResult() {
        // Implementation remains the same...
    }

    private void updateTime() {
        // Implementation remains the same...
    }

    private void updateTextView16Visibility() {
        if (isTextView16Visible) {
            textView16.setVisibility(View.VISIBLE);
        } else {
            textView16.setVisibility(View.GONE);
        }
    }

    private void showTime(String time) {
        resultLabel4.setText("Uhrzeit: " + time);
    }
}
