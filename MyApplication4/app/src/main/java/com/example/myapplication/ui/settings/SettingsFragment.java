package com.example.myapplication.ui.settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.LanguageManager;
import com.example.myapplication.R;

public class SettingsFragment extends Fragment {

    private ImageButton languageDE;
    private ImageButton languageES;
    private ImageButton languageHR;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        languageDE = rootView.findViewById(R.id.languageDE);
        languageES = rootView.findViewById(R.id.languageES);
        languageHR = rootView.findViewById(R.id.languageHR);

        LanguageManager languageManager = new LanguageManager(this.getActivity());

        languageDE.setOnClickListener(view -> {
            languageManager.updateResource("de");
            getParentFragmentManager().beginTransaction().detach(SettingsFragment.this).commit();
            getParentFragmentManager().beginTransaction().attach(SettingsFragment.this).commit();
        });
        languageES.setOnClickListener(view -> {
            languageManager.updateResource("es");
            getParentFragmentManager().beginTransaction().detach(SettingsFragment.this).commit();
            getParentFragmentManager().beginTransaction().attach(SettingsFragment.this).commit();
        });
        languageHR.setOnClickListener(view -> {
            languageManager.updateResource("hr");
            getParentFragmentManager().beginTransaction().detach(SettingsFragment.this).commit();
            getParentFragmentManager().beginTransaction().attach(SettingsFragment.this).commit();
        });

        return rootView;
    }
}
