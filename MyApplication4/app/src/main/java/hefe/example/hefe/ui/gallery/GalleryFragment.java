package hefe.example.hefe.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import hefe.example.hefe.R;

public class GalleryFragment extends Fragment {

    private ConstraintLayout constraintLayout;
    private TextView headlineTextView1;
    private TextView contentTextView1;
    private TextView headlineTextView2;
    private TextView contentTextView2;
    private TextView headlineTextView3;
    private TextView contentTextView3;
    private TextView headlineTextView4;
    private TextView contentTextView4;
    private TextView headlineTextView5;
    private TextView contentTextView5;

    private boolean isContentVisible1 = false;
    private boolean isContentVisible2 = false;
    private boolean isContentVisible3 = false;
    private boolean isContentVisible4 = false;
    private boolean isContentVisible5 = false;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        constraintLayout = rootView.findViewById(R.id.constraintLayout);
        headlineTextView1 = rootView.findViewById(R.id.headlineTextView1);
        contentTextView1 = rootView.findViewById(R.id.contentTextView1);
        headlineTextView2 = rootView.findViewById(R.id.headlineTextView2);
        contentTextView2 = rootView.findViewById(R.id.contentTextView2);
        headlineTextView3 = rootView.findViewById(R.id.headlineTextView3);
        contentTextView3 = rootView.findViewById(R.id.contentTextView3);
        headlineTextView4 = rootView.findViewById(R.id.headlineTextView4);
        contentTextView4 = rootView.findViewById(R.id.contentTextView4);
        headlineTextView5 = rootView.findViewById(R.id.headlineTextView5);
        contentTextView5 = rootView.findViewById(R.id.contentTextView5);

        headlineTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContentVisible1 = !isContentVisible1;
                updateVisibility(contentTextView1, isContentVisible1);
                updateConstraints();
            }
        });

        headlineTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContentVisible2 = !isContentVisible2;
                updateVisibility(contentTextView2, isContentVisible2);
                updateConstraints();
            }
        });

        headlineTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContentVisible3 = !isContentVisible3;
                updateVisibility(contentTextView3, isContentVisible3);
                updateConstraints();
            }
        });

        headlineTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContentVisible4 = !isContentVisible4;
                updateVisibility(contentTextView4, isContentVisible4);
                updateConstraints();
            }
        });

        headlineTextView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContentVisible5 = !isContentVisible5;
                updateVisibility(contentTextView5, isContentVisible5);
                updateConstraints();
            }
        });

        return rootView;
    }

    private void updateVisibility(TextView textView, boolean isVisible) {
        if (isVisible) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    private void updateConstraints() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        if (isContentVisible1) {
            constraintSet.connect(R.id.headlineTextView2, ConstraintSet.TOP, R.id.contentTextView1, ConstraintSet.BOTTOM, 16);
        } else {
            constraintSet.connect(R.id.headlineTextView2, ConstraintSet.TOP, R.id.headlineTextView1, ConstraintSet.BOTTOM, 16);
        }

        if (isContentVisible2) {
            constraintSet.connect(R.id.headlineTextView3, ConstraintSet.TOP, R.id.contentTextView2, ConstraintSet.BOTTOM, 16);
        } else {
            constraintSet.connect(R.id.headlineTextView3, ConstraintSet.TOP, R.id.headlineTextView2, ConstraintSet.BOTTOM, 16);
        }

        if (isContentVisible3) {
            constraintSet.connect(R.id.headlineTextView4, ConstraintSet.TOP, R.id.contentTextView3, ConstraintSet.BOTTOM, 16);
        } else {
            constraintSet.connect(R.id.headlineTextView4, ConstraintSet.TOP, R.id.headlineTextView3, ConstraintSet.BOTTOM, 16);
        }

        if (isContentVisible4) {
            constraintSet.connect(R.id.headlineTextView5, ConstraintSet.TOP, R.id.contentTextView4, ConstraintSet.BOTTOM, 16);
        } else {
            constraintSet.connect(R.id.headlineTextView5, ConstraintSet.TOP, R.id.headlineTextView4, ConstraintSet.BOTTOM, 16);
        }

        constraintSet.applyTo(constraintLayout);
    }
}

