package com.example.wojder.exerciset.utils;

import android.support.v4.app.Fragment;

import com.example.wojder.exerciset.view.fragments.CalculatorFragment;

/**
 * Created by wojder on 24.02.16.
 */
public enum ContentFragment {

    calculator(new CalculatorFragment());

    private Fragment fragment;

    private ContentFragment (Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
