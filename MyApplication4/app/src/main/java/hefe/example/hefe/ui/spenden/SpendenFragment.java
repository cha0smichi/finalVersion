package hefe.example.hefe.ui.spenden;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hefe.example.hefe.R;
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

import java.util.Random;

public class SpendenFragment extends Fragment {

    private RewardedAd rewardedAd;
    private final String TAG = "SpendenFragment";

    // UI Elements
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
    private TextView textView20;
    private TextView textView22;
    private TextView textView41;
    private TextView textView42;
    private TextView textView23;
    private Button button6;
    private Button button5;
    private Button button4;

    // Data
    private boolean isTextView17Visible = false;
    private boolean isTextView18Visible = false;
    private boolean isTextView20Visible = false;
    private boolean isTextView41Visible = false;
    private boolean isTextView42Visible = false;
    private boolean isTextView23Visible = false;

    private boolean isRewardEarned = false;

    private SharedPreferences sharedPreferences;
    private final String SP_KEY_IS_REWARD_EARNED = "is_reward_earned";
    private final String SP_KEY_IS_TEXTVIEW23_VISIBLE = "is_textView23_visible";

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_spenden, container, false);

        // Initialize AdMob
        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Load RewardedAd
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

        // Find views by their IDs
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

        // Set initial visibility of TextViews and Buttons to "gone"
        textView17.setVisibility(View.GONE);
        textView18.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        textView20.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        textView41.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        textView42.setVisibility(View.GONE);

        // Set click listeners for expanding TextViews
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
                isTextView23Visible = !isTextView23Visible;
                updateVisibility(textView23, isTextView23Visible);
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

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });

        // Initialize SharedPreferences
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        // Retrieve the saved reward status
        isRewardEarned = sharedPreferences.getBoolean(SP_KEY_IS_REWARD_EARNED, false);
        // Retrieve the saved visibility status of textView23
        isTextView23Visible = sharedPreferences.getBoolean(SP_KEY_IS_TEXTVIEW23_VISIBLE, false);

        // Update the visibility of the reward
        updateRewardVisibility();
        // Update the visibility of textView23 based on its saved state
        updateVisibility(textView23, isTextView23Visible);

        return rootView;
    }

    // Method to update the visibility of a TextView
    private void updateVisibility(TextView textView, boolean isVisible) {
        if (isVisible) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    // Method to update constraints, if necessary
    private void updateConstraints() {
        // Adjust the constraints based on the visibility of the elements

        // For Button 6 and TextView20
        if (isTextView20Visible) {
            // If TextView20 is visible, make Button 6 visible and set its constraints accordingly
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

        // Save the visibility state of textView23 in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SP_KEY_IS_TEXTVIEW23_VISIBLE, isTextView23Visible);
        editor.apply();
    }

    // Method to update the visibility of the reward TextView
    private void updateRewardVisibility() {
        if (isRewardEarned) {
            textView23.setVisibility(View.VISIBLE);
        } else {
            textView23.setVisibility(View.GONE);
        }
    }

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

                    // Show a random message as a reward
                    String randomMessage = getRandomMessageFromResources();
                    textView23.setText("Deine Glückskeksnachricht ist:" + randomMessage);

                    // Make textView23 visible since the reward has been shown
                    textView23.setVisibility(View.VISIBLE);

                    // Set the flag to indicate that the reward has been earned
                    isRewardEarned = true;

                    // Save the reward status in SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(SP_KEY_IS_REWARD_EARNED, true);
                    editor.apply();
                }
            });
        } else {
            // Handle the case when the rewarded ad is not loaded or failed to load.
        }
    }

    // Method to get a random message from string resources
    private String getRandomMessageFromResources() {
        // Array of resource IDs for the random messages
        int[] messageIds = {
                R.string.Code1,
                R.string.Code2,
                R.string.Code3,
                R.string.Code4,
                R.string.Code5,
                R.string.Code6,
                R.string.Code7,
                R.string.Code8,
                R.string.Code9,
                R.string.Code10,
                R.string.Code11,
                R.string.Code12,
                R.string.Code13,
                R.string.Code14,
                R.string.Code15,
                R.string.Code16,
                R.string.Code17,
                R.string.Code18,
                R.string.Code19,
                R.string.Code20,
                R.string.Code21,
                R.string.Code22,
                R.string.Code23,
                R.string.Code24,
                R.string.Code25,
                R.string.Code26,
                R.string.Code27,
                R.string.Code28,
                R.string.Code29,
                R.string.Code30,
                R.string.Code31,
                R.string.Code32,
                R.string.Code33,
                R.string.Code34,
                R.string.Code35,
                R.string.Code36,
                R.string.Code37,
                R.string.Code38,
                R.string.Code39,
                R.string.Code40
        };

        // Generate a random index
        int index = new Random().nextInt(messageIds.length);

        // Get the random message from the resources
        return getString(messageIds[index]);
    }

    // Method to open the website
    private void openWebsite() {
        // Add the URL of the website you want to open
        String websiteUrl = "https://ko-fi.com/hefehelfer";

        // Create an Intent to open the website
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));

        // Check if there is an app that can handle this Intent
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            // If there is an app that can handle the Intent, start the activity
            startActivity(intent);
        } else {
            // If there is no app that can handle the Intent, show an error message or handle it as needed
            Log.e(TAG, "No app can handle this Intent.");
            Toast.makeText(getActivity(), "No app can handle this action.", Toast.LENGTH_SHORT).show();
        }
    }

    // Rest of your methods...
}
