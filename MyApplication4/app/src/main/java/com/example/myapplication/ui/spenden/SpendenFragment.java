package com.example.myapplication.ui.spenden;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class SpendenFragment extends Fragment {

    private TextView headlineTextView1;
    private TextView ueberschrift2;
    private TextView headlineTextView2;
    private TextView headlineTextView3;
    private TextView textView17;
    private TextView textView18;
    private TextView headlineTextView6;
    private TextView headlineTextView7;
    private TextView headlineTextView8;
    private TextView headlineTextView9;

    private TextView textView22;
    private TextView textView20;
    private TextView textView41;
    private TextView textView42;
    private Button button6;
    private Button button5;
    private Button button4;

    private boolean isTextView17Visible = false;
    private boolean isTextView18Visible = false;
    private boolean isTextView20Visible = false;
    private boolean isTextView41Visible = false;
    private boolean isTextView42Visible = false;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_spenden, container, false);
        headlineTextView1 = rootView.findViewById(R.id.headlineTextView1);
        ueberschrift2 = rootView.findViewById(R.id.ueberschrift2);
        headlineTextView2 = rootView.findViewById(R.id.headlineTextView2);
        headlineTextView3 = rootView.findViewById(R.id.headlineTextView3);
        textView17 = rootView.findViewById(R.id.textView17);
        textView18 = rootView.findViewById(R.id.textView18);
        headlineTextView6 = rootView.findViewById(R.id.headlineTextView6);
        headlineTextView7 = rootView.findViewById(R.id.headlineTextView7);
        headlineTextView8 = rootView.findViewById(R.id.headlineTextView8);
        headlineTextView9 = rootView.findViewById(R.id.headlineTextView9);
        textView20 = rootView.findViewById(R.id.textView20);
        textView22 = rootView.findViewById(R.id.textView22);
        textView41 = rootView.findViewById(R.id.textView41);
        textView42 = rootView.findViewById(R.id.textView42);

        button6 = rootView.findViewById(R.id.button6);
        button5 = rootView.findViewById(R.id.button5);
        button4 = rootView.findViewById(R.id.button4);

        // Setze die Sichtbarkeit der TextViews und Buttons auf "gone" zu Beginn
        textView17.setVisibility(View.GONE);
        textView18.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        textView20.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        textView41.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        textView42.setVisibility(View.GONE);

        headlineTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTextView17Visible = !isTextView17Visible;
                updateVisibility(textView17, isTextView17Visible);
                updateConstraints();
            }
        });

        headlineTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTextView18Visible = !isTextView18Visible;
                updateVisibility(textView18, isTextView18Visible);
                updateConstraints();
            }
        });

        headlineTextView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTextView20Visible = !isTextView20Visible;
                updateVisibility(button6, isTextView20Visible);
                updateVisibility(textView20, isTextView20Visible);
                updateConstraints();
            }
        });

        headlineTextView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTextView41Visible = !isTextView41Visible;
                updateVisibility(button5, isTextView41Visible);
                updateVisibility(textView41, isTextView41Visible);
                updateConstraints();
            }
        });

        headlineTextView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTextView42Visible = !isTextView42Visible;
                updateVisibility(button4, isTextView42Visible);
                updateVisibility(textView42, isTextView42Visible);
                updateConstraints();
            }
        });

        return rootView;
    }

    // Methode zum Aktualisieren der Sichtbarkeit des TextViews
    private void updateVisibility(TextView textView, boolean isVisible) {
        if (isVisible) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    // Methode zum Aktualisieren von Constraints, falls notwendig
    private void updateConstraints() {
        // Adjust the constraints based on visibility of the elements

        // For Button 6 and textView20
        if (isTextView20Visible) {
            // If textView20 is visible, make Button 6 visible and set its constraints accordingly
            button6.setVisibility(View.VISIBLE);
            // Add code to adjust the constraints for Button 6 as needed
        } else {
            button6.setVisibility(View.GONE);
            // Add code to adjust constraints to hide Button 6 if needed
        }

        // For Button 5 and TextView41
        if (isTextView41Visible) {
            // If TextView41 is visible, make Button 5 visible and set its constraints accordingly
            button5.setVisibility(View.VISIBLE);
            // Add code to adjust the constraints for Button 5 as needed
        } else {
            button5.setVisibility(View.GONE);
            // Add code to adjust constraints to hide Button 5 if needed
        }

        // For Button 4 and TextView42
        if (isTextView42Visible) {
            // If TextView42 is visible, make Button 4 visible and set its constraints accordingly
            button4.setVisibility(View.VISIBLE);
            // Add code to adjust the constraints for Button 4 as needed
        } else {
            button4.setVisibility(View.GONE);
            // Add code to adjust constraints to hide Button 4 if needed
        }
    }
}
