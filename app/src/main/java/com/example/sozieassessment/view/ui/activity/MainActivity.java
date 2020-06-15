package com.example.sozieassessment.view.ui.activity;

import android.os.Bundle;

import com.example.sozieassessment.R;
import com.example.sozieassessment.databinding.ActivityMainBinding;
import com.example.sozieassessment.utils.UtilsGeneral;
import com.example.sozieassessment.view.ui.fragment.AddMeasurementFragment;
import com.example.sozieassessment.view.ui.fragment.BodySelectionFragment;
import com.example.sozieassessment.view.ui.fragment.HowToMeasureFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Showing Body Selection Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(viewBinding.contentMain.containerMain.getId(), new BodySelectionFragment(), "");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void gotoBodyMeasurementScreen(UtilsGeneral.BodyType bodyType){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        Bundle bundle = new Bundle();
        bundle.putString(UtilsGeneral.EXTRA_BODY_TYPE, bodyType.toString());

        AddMeasurementFragment fragment = new AddMeasurementFragment();
        fragment.setArguments(bundle);

        transaction.replace(viewBinding.contentMain.containerMain.getId(), fragment, "");
        transaction.addToBackStack("AddMeasurementFragment");
        transaction.commit();
    }

    public void gotoHowToMeasureScreen(UtilsGeneral.BodyType bodyType){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_top, R.anim.enter_from_top, R.anim.exit_to_bottom);
        Bundle bundle = new Bundle();
        bundle.putString(UtilsGeneral.EXTRA_BODY_TYPE, bodyType.toString());

        HowToMeasureFragment fragment = new HowToMeasureFragment();
        fragment.setArguments(bundle);

        transaction.replace(viewBinding.contentMain.containerMain.getId(), fragment, "");
        transaction.addToBackStack("HowToMeasureFragment");
        transaction.commit();
    }
}