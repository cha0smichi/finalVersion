package hefe.example.hefe.ui.rechner;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import hefe.example.hefe.R;

public class RechnerFragment extends Fragment {

    private Button button3;
    private TextView ueberschrfit;
    private Button calculateButton;
    private EditText textView7, textView8, textView9, textView10, textView11, textView12;
    private EditText textView20, textView21, textView22, textView23, textView24, textView25, textView27;
    private TextView textView16, textView40, textView2, textView41, textView42, textView43, textView44, textView45;
    private TextView textView50, textView51, textView52, textView53, textView54, textView55;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rechner, container, false);

        // Initialisierung der Views
        button3 = rootView.findViewById(R.id.button3);
        ueberschrfit = rootView.findViewById(R.id.ueberschrfit);
        calculateButton = rootView.findViewById(R.id.calculateButton);
        textView7 = rootView.findViewById(R.id.textView7);
        textView8 = rootView.findViewById(R.id.textView8);
        textView9 = rootView.findViewById(R.id.textView9);
        textView10 = rootView.findViewById(R.id.textView10);
        textView11 = rootView.findViewById(R.id.textView11);
        textView12 = rootView.findViewById(R.id.textView12);
        textView16 = rootView.findViewById(R.id.textView16);
        textView40 = rootView.findViewById(R.id.textView40);
        textView2 = rootView.findViewById(R.id.textView2);
        textView41 = rootView.findViewById(R.id.textView41);
        textView42 = rootView.findViewById(R.id.textView42);
        textView43 = rootView.findViewById(R.id.textView43);
        textView44 = rootView.findViewById(R.id.textView44);
        textView45 = rootView.findViewById(R.id.textView45);
        textView20 = rootView.findViewById(R.id.textView20);
        textView21 = rootView.findViewById(R.id.textView21);
        textView22 = rootView.findViewById(R.id.textView22);
        textView23 = rootView.findViewById(R.id.textView23);
        textView24 = rootView.findViewById(R.id.textView24);
        textView25 = rootView.findViewById(R.id.textView25);
        textView27 = rootView.findViewById(R.id.textView27);
        textView50 = rootView.findViewById(R.id.textView50);
        textView51 = rootView.findViewById(R.id.textView51);
        textView52 = rootView.findViewById(R.id.textView52);
        textView53 = rootView.findViewById(R.id.textView53);
        textView54 = rootView.findViewById(R.id.textView54);
        textView55 = rootView.findViewById(R.id.textView55);

        textView16.setVisibility(View.GONE);

        // Hier kannst du die entsprechenden Aktionen für die Buttons oder andere Views hinzufügen
        // TextWatcher, um die Eingabe in EditText zu überwachen
        textView7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Setze den Text des TextView40 auf den eingegebenen Text in TextView7
                textView40.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nicht benötigt
            }
        });
        textView8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Setze den Text des textView41 auf den eingegebenen Text in textView8
                textView41.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nicht benötigt
            }
        });

        textView9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Setze den Text des textView41 auf den eingegebenen Text in textView8
                textView42.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nicht benötigt
            }
        });
        textView10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Setze den Text des textView41 auf den eingegebenen Text in textView8
                textView43.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nicht benötigt
            }
        });

        textView11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Setze den Text des textView41 auf den eingegebenen Text in textView8
                textView44.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nicht benötigt
            }
        });

        textView12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Setze den Text des textView41 auf den eingegebenen Text in textView8
                textView45.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nicht benötigt
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values from TextView20 to TextView25 and TextView27 as strings
                String valueTextView20 = textView20.getText().toString();
                String valueTextView21 = textView21.getText().toString();
                String valueTextView22 = textView22.getText().toString();
                String valueTextView23 = textView23.getText().toString();
                String valueTextView24 = textView24.getText().toString();
                String valueTextView25 = textView25.getText().toString();
                String valueTextView27 = textView27.getText().toString();

                // Convert the strings to doubles (for decimal numbers)
                double doubleValueTextView20 = valueTextView20.isEmpty() ? 0.0 : Double.parseDouble(valueTextView20);
                double doubleValueTextView21 = valueTextView21.isEmpty() ? 0.0 : Double.parseDouble(valueTextView21);
                double doubleValueTextView22 = valueTextView22.isEmpty() ? 0.0 : Double.parseDouble(valueTextView22);
                double doubleValueTextView23 = valueTextView23.isEmpty() ? 0.0 : Double.parseDouble(valueTextView23);
                double doubleValueTextView24 = valueTextView24.isEmpty() ? 0.0 : Double.parseDouble(valueTextView24);
                double doubleValueTextView25 = valueTextView25.isEmpty() ? 0.0 : Double.parseDouble(valueTextView25);
                double doubleValueTextView27 = valueTextView27.isEmpty() ? 0.0 : Double.parseDouble(valueTextView27);

                // Calculate the multiplication results with decimal precision
                double result1 = doubleValueTextView20 * doubleValueTextView27;
                double result2 = doubleValueTextView21 * doubleValueTextView27;
                double result3 = doubleValueTextView22 * doubleValueTextView27;
                double result4 = doubleValueTextView23 * doubleValueTextView27;
                double result5 = doubleValueTextView24 * doubleValueTextView27;
                double result6 = doubleValueTextView25 * doubleValueTextView27;

                // Set the results in TextViews with appropriate decimal formatting
                textView50.setText(result1 == 0.0 ? "" : String.format("%.2f", result1));
                textView51.setText(result2 == 0.0 ? "" : String.format("%.2f", result2));
                textView52.setText(result3 == 0.0 ? "" : String.format("%.2f", result3));
                textView53.setText(result4 == 0.0 ? "" : String.format("%.2f", result4));
                textView54.setText(result5 == 0.0 ? "" : String.format("%.2f", result5));
                textView55.setText(result6 == 0.0 ? "" : String.format("%.2f", result6));
            }
        });


        // ... your existing code ...

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of textView16 based on button3 click
                if (textView16.getVisibility() == View.VISIBLE) {
                    textView16.setVisibility(View.GONE);
                } else {
                    textView16.setVisibility(View.VISIBLE);
                }
            }
        });// Weitere Aktionen hinzufügen, wenn nötig...

        return rootView; // Return the inflated View here
    }



}
