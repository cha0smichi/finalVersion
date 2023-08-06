package hefe.example.hefe.ui.home;

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

import hefe.example.hefe.R;

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
    private EditText editText1;
    private EditText editText3;
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
       numberField.addTextChangedListener(decimalTextWatcher);
       Celsius.addTextChangedListener(decimalTextWatcher);

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

    private TextWatcher decimalTextWatcher = new TextWatcher() {
        private boolean isEditing;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (isEditing) return;
            isEditing = true;

            String originalText = s.toString();
            String formattedText = originalText.replace(',', '.');

            if (!formattedText.equals(originalText)) {
                // Wenn das Format geändert wurde, setze den neuen formatierten Text zurück
                s.replace(0, s.length(), formattedText);
            }

            isEditing = false;
        }
    };
    private void calculateResultLabel5() {
        String input1 = editText4.getText().toString().trim();
        String input2 = editText6.getText().toString().trim();

        if (input1.isEmpty() || input2.isEmpty()) {
            // If any of the input fields are empty, show an error message or handle it accordingly
            Toast.makeText(getActivity(), "Bitte geben Sie beide Werte ein", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double value1 = Double.parseDouble(input1);
            double value2 = Double.parseDouble(input2);

            // Perform your calculation for resultlabel5
            double result = value1 + (value2/60); // For example, you can add both values
            // Format the result to display only 2 decimal places

            resultLabel5 = result; // Update the resultLabel5 double variable

            // Update the TextView with the calculated value


        } catch (NumberFormatException e) {
            // Handle the parsing error, show an error message or handle it accordingly
            Toast.makeText(getActivity(), "Ungültige Eingabe", Toast.LENGTH_SHORT).show();
        }
    }

    private void calculateResult() {
        String input = numberField.getText().toString().trim();
        if (input.isEmpty()) {
            // Wenn das Feld leer ist, zeige eine Fehlermeldung oder handle es entsprechend
            Toast.makeText(getActivity(), "Bitte geben Sie eine Zahl ein", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double number = Double.parseDouble(input);
            double factor1 = resultLabel5; // Use the resultLabel5 double value instead of parsing it from the TextView
            double factor2 = Double.parseDouble(Celsius.getText().toString());

            if (factor2 < 6 || factor2 > 48) {
                Toast.makeText(getActivity(), "Bitte Grad im Bereich 6-48 angeben", Toast.LENGTH_SHORT).show();
                return;
            }

            // Berechnung von factor1 basierend auf dem Eingabebereich
            if (factor1 >= 0.1 && factor1 <= 38) {
                factor1 = 0.9986090369155 * Math.pow(factor1, -1.4482936391728);
            } else if (factor1 > 38 && factor1 <= 60) {
                factor1 = -0.0000000237485 * Math.pow(factor1, 4)
                        + 0.0000040372705 * Math.pow(factor1, 3)
                        - 0.0002555371044 * Math.pow(factor1, 2)
                        + 0.0070878839939 * factor1
                        - 0.070721168739;
            } else {
                Toast.makeText(getActivity(), "Der Wert für Stunden muss zwischen 0.1 und 60 liegen.", Toast.LENGTH_SHORT).show();
                return;
            }

            double result = (number * 0.4603 + 15.34) * (6.4167364361284 * Math.exp(-0.1857846786979 * factor2) * factor1);
            double dividedResult = result / 3.0;
            double result2 = result * 7;

            // Format the results to display only 2 decimal places
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedResult = decimalFormat.format(result);
            String formattedDividedResult = decimalFormat.format(dividedResult);
            String formattedResult2 = decimalFormat.format(result2);

            resultLabel.setText(formattedResult);
            resultLabel2.setText(formattedDividedResult);
            resultLabel3.setText(formattedResult2);

        } catch (NumberFormatException e) {
            // Fehler beim Parsen der Zahl, zeige eine Fehlermeldung oder handle es entsprechend
            Toast.makeText(getActivity(), "Ungültige Eingabe", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTime() {
        // Use the resultLabel5 double value directly
        double selectedFactor = resultLabel5;

        // Convert the selectedFactor from hours to minutes
        int minutesToAdd = (int) (selectedFactor * 60);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        calendar.add(Calendar.MINUTE, minutesToAdd); // Add the calculated minutes to the current time

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String currentTime = String.format("%02d:%02d", hour, minute);
        showTime(currentTime);
    }



    private void updateTextView16Visibility() {
        if (isTextView16Visible) {
            textView16.setVisibility(View.VISIBLE);
        } else {
            textView16.setVisibility(View.GONE);
        }
    }

    private void showTime(String time) {
        resultLabel4.setText(time);
    }
}
