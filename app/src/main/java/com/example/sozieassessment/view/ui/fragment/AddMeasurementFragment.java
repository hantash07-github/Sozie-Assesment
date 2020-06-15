package com.example.sozieassessment.view.ui.fragment;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sozieassessment.R;
import com.example.sozieassessment.databinding.FragmentAddMeasurementBinding;
import com.example.sozieassessment.utils.UtilsGeneral;
import com.example.sozieassessment.view.ui.activity.MainActivity;

public class AddMeasurementFragment extends Fragment implements View.OnClickListener {
    private FragmentAddMeasurementBinding viewBinding;
    private UtilsGeneral.BodyType bodyType;

    private boolean isInSelected = true;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_measurement, container, false);

        Bundle bundle = getArguments();
        if (bundle != null){
            String bodyTypeSrt = bundle.getString(UtilsGeneral.EXTRA_BODY_TYPE, "");
            bodyType = UtilsGeneral.BodyType.fromString(bodyTypeSrt);

            if (bodyType == UtilsGeneral.BodyType.MALE){
                viewBinding.containerChest.setVisibility(View.VISIBLE);
                viewBinding.lineChest.setVisibility(View.VISIBLE);
                viewBinding.containerBraSize.setVisibility(View.GONE);
                viewBinding.lineBraSize.setVisibility(View.GONE);
                viewBinding.btnMeasurement.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.btn_base_male));
            }
            else if (bodyType == UtilsGeneral.BodyType.FEMALE){
                viewBinding.containerChest.setVisibility(View.GONE);
                viewBinding.lineChest.setVisibility(View.GONE);
                viewBinding.containerBraSize.setVisibility(View.VISIBLE);
                viewBinding.lineBraSize.setVisibility(View.VISIBLE);
                viewBinding.btnMeasurement.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.btn_base_female));
            }
        }

        viewBinding.tvHowToMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null)
                    ((MainActivity)getActivity()).gotoHowToMeasureScreen(bodyType);
            }
        });

        viewBinding.tvSelectionIn.setOnClickListener(this);
        viewBinding.tvSelectionCm.setOnClickListener(this);

        return viewBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (isInSelected){
            viewBinding.tvSelectionIn.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorBlack));
            viewBinding.tvSelectionIn.setBackground(null);

            viewBinding.tvSelectionCm.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));
            viewBinding.tvSelectionCm.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.style_bg_gray));

            isInSelected = false;
        }
        else {
            viewBinding.tvSelectionCm.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorBlack));
            viewBinding.tvSelectionCm.setBackground(null);

            viewBinding.tvSelectionIn.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));
            viewBinding.tvSelectionIn.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.style_bg_gray));

            isInSelected = true;
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(AddMeasurementFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }
}