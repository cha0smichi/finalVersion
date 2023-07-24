package com.example.myapplication.ui.spenden;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class SpendenFragment {
}
    private TextView headlineTextView1;
    private TextView ueberschrift2;
    private TextView headlineTextView2;
    private TextView headlineTextView3;
    private TextView textView17;
    private TextView textView18;

    private boolean isTextView17Visible = false;
    private boolean isTextView18Visible = false;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        headlineTextView1 = rootView.findViewById(R.id.headlineTextView1);
        ueberschrift2 = rootView.findViewById(R.id.ueberschrift2);
        headlineTextView2 = rootView.findViewById(R.id.headlineTextView2);
        headlineTextView3 = rootView.findViewById(R.id.headlineTextView3);
        textView17 = rootView.findViewById(R.id.textView17);
        textView18 = rootView.findViewById(R.id.textView18);

        // Setze die Sichtbarkeit der TextViews auf "gone" zu Beginn
        textView17.setVisibility(View.GONE);
        textView18.setVisibility(View.GONE);

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
        // Füge hier den Code ein, um die Constraints anzupassen, falls erforderlich
    }
}
