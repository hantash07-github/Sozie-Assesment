package com.example.sozieassessment.view.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sozieassessment.R;
import com.example.sozieassessment.databinding.FragmentHowToMeausreBinding;
import com.example.sozieassessment.utils.UtilsGeneral;
import com.example.sozieassessment.view.ui.activity.MainActivity;

public class HowToMeasureFragment extends Fragment {
    private FragmentHowToMeausreBinding viewBinding;
    private UtilsGeneral.BodyType bodyType;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_how_to_meausre, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String bodyTypeSrt = bundle.getString(UtilsGeneral.EXTRA_BODY_TYPE, "");
            bodyType = UtilsGeneral.BodyType.fromString(bodyTypeSrt);

            showScreenContent(bodyType);
        }

        viewBinding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null)
                    ((MainActivity)getActivity()).onBackPressed();
            }
        });

        return viewBinding.getRoot();
    }

    private void showScreenContent(UtilsGeneral.BodyType bodyType) {
        if (bodyType == UtilsGeneral.BodyType.MALE){
            viewBinding.ivBodyMeasurement.setImageResource(R.drawable.male_body_measurement);
            viewBinding.ivHeight.setImageResource(R.drawable.a_blue);
            viewBinding.ivChest.setImageResource(R.drawable.b_blue);
            viewBinding.ivWaist.setImageResource(R.drawable.c_blue);
            viewBinding.ivHips.setImageResource(R.drawable.d_blue);
            viewBinding.ivBodyMeasurement.setImageResource(R.drawable.male_body_measurement);
            viewBinding.containerMaleChest.setVisibility(View.VISIBLE);
        }
        else if (bodyType == UtilsGeneral.BodyType.FEMALE){
            viewBinding.ivBodyMeasurement.setImageResource(R.drawable.body_measurement);
            viewBinding.ivHeight.setImageResource(R.drawable.a_pink);
            viewBinding.ivWaist.setImageResource(R.drawable.b_pink);
            viewBinding.ivHips.setImageResource(R.drawable.c_pink);
            viewBinding.containerMaleChest.setVisibility(View.GONE);
        }
    }
}