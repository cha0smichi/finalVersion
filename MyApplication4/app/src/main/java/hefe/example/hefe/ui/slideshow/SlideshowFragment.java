package hefe.example.hefe.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

import androidx.fragment.app.Fragment;
import hefe.example.hefe.R;

public class SlideshowFragment extends Fragment {

    private TextView headlineTextView1;
    private TextView headlineTextView2;
    private TextView headlineTextView3;
    private TextView headlineTextView4;
    private TextView headlineTextView5;
    private TextView headlineTextView6;
    private TextView textView13; // New TextView for textView13
    private TextView textView14; // New TextView for textView14
    private TextView textView15; // New TextView for textView15
    private EditText inputEditText1;
    private EditText inputEditText2; // New EditText
    private TextView outputTextView1;
    private TextView outputTextView2; // New TextView for Output
    private TextView textView12; // New TextView
    private TextView textView11; // New TextView
    private ImageView editText1;
    private ImageView editText2;
    private ImageView editText3;
    private ImageView editText4;
    private Button button;
    private Button button2; // New Button

    private EditText linealEditText; // New EditText for lineal

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slideshow, container, false);

        headlineTextView1 = rootView.findViewById(R.id.headlineTextView1);
        headlineTextView2 = rootView.findViewById(R.id.headlineTextView2);
        headlineTextView3 = rootView.findViewById(R.id.headlineTextView3);
        headlineTextView4 = rootView.findViewById(R.id.headlineTextView4);
        headlineTextView5 = rootView.findViewById(R.id.headlineTextView5);
        headlineTextView6 = rootView.findViewById(R.id.headlineTextView6);
        textView13 = rootView.findViewById(R.id.textView13); // Initialize textView13
        textView14 = rootView.findViewById(R.id.textView14); // Initialize textView14
        textView15 = rootView.findViewById(R.id.textView15); // Initialize textView15
        inputEditText1 = rootView.findViewById(R.id.inputEditText1);
        inputEditText2 = rootView.findViewById(R.id.inputEditText2); // Initialize inputEditText2
        outputTextView1 = rootView.findViewById(R.id.outputTextView1);
        outputTextView2 = rootView.findViewById(R.id.outputTextView2); // Initialize outputTextView2
        textView12 = rootView.findViewById(R.id.textView12); // Initialize textView12
        textView11 = rootView.findViewById(R.id.textView11); // Initialize textView11
        button = rootView.findViewById(R.id.button);
        button2 = rootView.findViewById(R.id.button2); // Initialize button2
        editText1 = rootView.findViewById(R.id.EditText1);
        editText2 = rootView.findViewById(R.id.EditText2);
        editText3 = rootView.findViewById(R.id.EditText3);
        editText4 = rootView.findViewById(R.id.EditText4);


        linealEditText = rootView.findViewById(R.id.linealEditText); // Initialize linealEditText

        // Set the initial visibility of views
        headlineTextView2.setVisibility(View.GONE);
        headlineTextView3.setVisibility(View.GONE);
        headlineTextView5.setVisibility(View.GONE);
        headlineTextView6.setVisibility(View.GONE);
        textView13.setVisibility(View.GONE); // Hide textView13 initially
        textView14.setVisibility(View.GONE); // Hide textView14 initially
        textView15.setVisibility(View.GONE); // Hide textView15 initially
        inputEditText1.setVisibility(View.GONE);
        inputEditText2.setVisibility(View.GONE); // Hide inputEditText2 initially
        outputTextView1.setVisibility(View.GONE);
        outputTextView2.setVisibility(View.GONE); // Hide outputTextView2 initially
        button.setVisibility(View.GONE);
        button2.setVisibility(View.GONE); // Hide button2 initially
        textView12.setVisibility(View.GONE); // Hide textView12 initially
        textView11.setVisibility(View.GONE); // Hide textView11 initially
        linealEditText.setVisibility(View.GONE); // Hide linealEditText initially
        textView15.setVisibility(View.GONE); // Hide textView15 initially
        editText1.setVisibility(View.GONE);
        editText2.setVisibility(View.GONE);
        editText3.setVisibility(View.GONE);
        editText4.setVisibility(View.GONE);


        // Set the OnClickListener for headlineTextView1
        headlineTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(headlineTextView2);
                toggleVisibility(headlineTextView3);
                toggleVisibility(inputEditText1);
                toggleVisibility(outputTextView1);
                toggleVisibility(button);
                toggleVisibility(inputEditText2);
                toggleVisibility(outputTextView2);
                toggleVisibility(button2);
                toggleVisibility(textView12);
                toggleVisibility(textView11); // Toggle visibility of textView11
                toggleVisibility(linealEditText); // Toggle visibility of linealEditText

            }
        });


        // Set the OnClickListener for headlineTextView4
        headlineTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(headlineTextView5);
                toggleVisibility(headlineTextView6);
                toggleVisibility(textView13); // Toggle visibility of textView13
                toggleVisibility(textView14); // Toggle visibility of textView14
                toggleVisibility(textView15); // Toggle visibility of textView15
                toggleImageVisibility(editText3); // Toggle visibility of editText3
                toggleImageVisibility(editText4); //
                toggleImageVisibility(editText1); // Toggle visibility of editText1
                toggleImageVisibility(editText2);
            }
        });

        // Set the OnClickListener for button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayOutput();
            }
        });

        // Set the OnClickListener for button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayOutput2();
            }
        });

        return rootView;
    }

    // Helper method to toggle the visibility of TextViews and adjust constraints
    private void toggleVisibility(TextView textView) {
        int visibility = textView.getVisibility();
        if (visibility == View.GONE) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
        // Update the constraints to reflect the visibility change
        textView.requestLayout();
    }
        private void toggleImageVisibility(ImageView imageView) {
            int visibility = imageView.getVisibility();
            if (visibility == View.GONE) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }
            // Update the constraints to reflect the visibility change
            imageView.requestLayout();

    }

    // Helper method to calculate and display the output for inputEditText1
    private void calculateAndDisplayOutput() {
        try {
            // Get the input value and convert it to a double
            String inputStr = inputEditText1.getText().toString().trim();
            double inputVal = Double.parseDouble(inputStr);

            // Perform the calculation (Multiply by 0.5) and display the result
            double outputVal = inputVal * 0.6;
            outputTextView1.setText(String.valueOf(outputVal));
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric values)
            outputTextView1.setText("Invalid Input");
        }
    }

    // Helper method to calculate and display the output for inputEditText2
    private void calculateAndDisplayOutput2() {
        try {
            // Get the input value and convert it to a double
            String inputStr = inputEditText2.getText().toString().trim();
            double inputVal = Double.parseDouble(inputStr);

            // Divide the input value by 10
            double dividedInputVal = inputVal / 10.0;

            // Perform the calculation (using the provided formula)
            double outputVal = 0.5380136417072 * Math.pow(dividedInputVal, 3) +
                    0.3809451781127 * Math.pow(dividedInputVal, 2) -
                    0.4613148920107 * dividedInputVal + 0.1392819630034;

            // Format the outputVal to display only 2 decimal places
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedOutput = decimalFormat.format(outputVal);

            outputTextView2.setText(formattedOutput);
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric values)
            outputTextView2.setText("Invalid Input");
        }
    }
}
