package com.example.sozieassessment.view.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sozieassessment.R;
import com.example.sozieassessment.databinding.FragmentBodySelectionBinding;
import com.example.sozieassessment.utils.UtilsGeneral;
import com.example.sozieassessment.view.ui.activity.MainActivity;

public class BodySelectionFragment extends Fragment {
    private FragmentBodySelectionBinding viewBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_body_selection, container, false);

        viewBinding.btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null)
                    ((MainActivity)getActivity()).gotoBodyMeasurementScreen(UtilsGeneral.BodyType.MALE);
            }
        });

        viewBinding.btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null)
                    ((MainActivity)getActivity()).gotoBodyMeasurementScreen(UtilsGeneral.BodyType.FEMALE);
            }
        });

        return viewBinding.getRoot();
    }
}