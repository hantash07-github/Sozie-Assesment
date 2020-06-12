package com.example.sozieassessment.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WishListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WishListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the wish list fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}