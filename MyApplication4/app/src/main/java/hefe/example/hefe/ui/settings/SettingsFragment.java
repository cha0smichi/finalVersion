package hefe.example.hefe.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hefe.example.hefe.LanguageManager;
import hefe.example.hefe.R;

public class SettingsFragment extends Fragment {

    private ImageButton languageDE;
    private ImageButton languageES;
    private ImageButton languageHR;
    private ImageButton languageFR;
    private ImageButton languageIT;
    private ImageButton languageJA;
    private ImageButton languageNL;
    private ImageButton languageRU;
    private ImageButton languageTR;
    private ImageButton languageUK;
    private ImageButton languageEN;
    private ImageButton languagePL;
    private ImageButton languageSA;
    private ImageButton languageCN;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        languageDE = rootView.findViewById(R.id.languageDE);
        languageES = rootView.findViewById(R.id.languageES);
        languageHR = rootView.findViewById(R.id.languageHR);
        languageFR = rootView.findViewById(R.id.languageFR);
        languageIT = rootView.findViewById(R.id.languageIT);
        languageJA = rootView.findViewById(R.id.languageJA);
        languageNL = rootView.findViewById(R.id.languageNL);
        languageRU = rootView.findViewById(R.id.languageRU);
        languageTR = rootView.findViewById(R.id.languageTR);
        languageUK = rootView.findViewById(R.id.languageUK);
        languageEN = rootView.findViewById(R.id.languageEN);
        languagePL = rootView.findViewById(R.id.languagePL);
        languageSA = rootView.findViewById(R.id.languageSA);
        languageCN = rootView.findViewById(R.id.languageCN);

        LanguageManager languageManager = new LanguageManager(getActivity());

        languageDE.setOnClickListener(view -> {
            languageManager.updateResource("de");
            restartActivity();
        });
        languageES.setOnClickListener(view -> {
            languageManager.updateResource("es");
            restartActivity();
        });
        languageHR.setOnClickListener(view -> {
            languageManager.updateResource("hr");
            restartActivity();
        });
        languageFR.setOnClickListener(view -> {
            languageManager.updateResource("fr");
            restartActivity();
        });
        languageIT.setOnClickListener(view -> {
            languageManager.updateResource("it");
            restartActivity();
        });
        languageJA.setOnClickListener(view -> {
            languageManager.updateResource("ja");
            restartActivity();
        });
        languageNL.setOnClickListener(view -> {
            languageManager.updateResource("nl");
            restartActivity();
        });
        languageRU.setOnClickListener(view -> {
            languageManager.updateResource("ru");
            restartActivity();
        });
        languageTR.setOnClickListener(view -> {
            languageManager.updateResource("tr");
            restartActivity();
        });
        languageUK.setOnClickListener(view -> {
            languageManager.updateResource("uk");
            restartActivity();
        });
        languageEN.setOnClickListener(view -> {
            languageManager.updateResource("en");
            restartActivity();
        });
        languagePL.setOnClickListener(view -> {
            languageManager.updateResource("pl");
            restartActivity();
        });
        languageSA.setOnClickListener(view -> {
            languageManager.updateResource("ar");
            restartActivity();
        });
        languageCN.setOnClickListener(view -> {
            languageManager.updateResource("zh");
            restartActivity();
        });

        return rootView;
    }

    // Helper method to restart the activity to apply language changes to all components
    private void restartActivity() {
        Intent intent = getActivity().getIntent();
        getActivity().finish();
        startActivity(intent);
    }
}
