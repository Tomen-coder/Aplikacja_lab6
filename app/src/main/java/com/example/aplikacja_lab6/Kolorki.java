package com.example.aplikacja_lab6;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Kolorki extends ViewModel {
    public final MutableLiveData<Integer> kolorki_layout1 = new MutableLiveData<>(Color.WHITE);
    public final MutableLiveData<Integer> kolorki_layout2 = new MutableLiveData<>(Color.WHITE);
    public final MutableLiveData<Integer> kolorki_layout3 = new MutableLiveData<>(Color.WHITE);

}
