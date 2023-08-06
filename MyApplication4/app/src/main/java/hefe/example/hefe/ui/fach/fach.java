package hefe.example.hefe.ui.fach;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hefe.example.hefe.R;


public class fach extends Fragment {
    private TextView textView39;
    private TextView textView41;
    private TextView ueberschrift4;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fach, container, false);

        ueberschrift4 = rootView.findViewById(R.id.ueberschrift4);
        textView39 = rootView.findViewById(R.id.textView39);


        return rootView;
    }

}