package com.example.myapplication.ui.settings;

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

public class SettingsFragment extends Fragment {

    private Button languageDE;
    private Button languageEN;
    private Button languageHR;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        languageDE = rootView.findViewById(R.id.languageDE);
        languageEN = rootView.findViewById(R.id.languageEN);
        languageHR = rootView.findViewById(R.id.languageHR);

        return rootView;
    }
}
