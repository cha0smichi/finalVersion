package com.example.myapplication.ui.spenden;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpendenFragment extends Fragment {

    private RewardedAd rewardedAd;
    private final String TAG = "SpendenFragment";

    private TextView headlineTextView1;
    private TextView ueberschrift2;
    private EditText textView23;
    private TextView headlineTextView2;
    private TextView headlineTextView3;

    private TextView textView17;
    private List<String> randomMessages = Arrays.asList(

            "Du bist großartig! Vielen Dank!",
            "Wir schätzen deine Spende sehr!",
            "Deine Hilfe macht einen Unterschied!"


    );
    private TextView textView18;


    private TextView headlineTextView6;

    private String getRandomMessage() {
        Random random = new Random();
        int index = random.nextInt(randomMessages.size());
        return randomMessages.get(index);
    }
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

    private boolean isTextView23Visible = false;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_spenden, container, false);
        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(getActivity(), "ca-app-pub-3940256099942544/5224354917",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.toString());
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;


                        rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                                Log.d(TAG, "Ad was clicked.");
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                Log.d(TAG, "Ad dismissed fullscreen content.");
                                rewardedAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                Log.e(TAG, "Ad failed to show fullscreen content.");
                                rewardedAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                                Log.d(TAG, "Ad recorded an impression.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                Log.d(TAG, "Ad showed fullscreen content.");
                            }
                        });

                    }
                });

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
        textView23 = rootView.findViewById(R.id.textView23);

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
        textView23.setVisibility(View.GONE);

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
                updateVisibility(textView23,isTextView23Visible);
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

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
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

    // Rest of your methods...

    public void click(View view) {
        if (rewardedAd != null) {
            Activity activityContext = getActivity();
            rewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    // Handle the reward.
                    Log.d(TAG, "The user earned the reward.");
                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();

                    // Setze den Anfangstext
                    textView23.setText("Dein Zukunft hält bereit: ");

                    // Zeige eine zufällige Nachricht als Belohnung an
                    String randomMessage = getRandomMessage();
                    textView23.append(randomMessage);

                    // Mache textView23 sichtbar, da der Reward angezeigt wurde
                    textView23.setVisibility(View.VISIBLE);
                }
            });
        } else {
            // Handle the case when the rewarded ad is not loaded or failed to load.
        }
    }
}
