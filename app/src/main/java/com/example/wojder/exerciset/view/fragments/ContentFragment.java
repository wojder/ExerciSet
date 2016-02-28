package com.example.wojder.exerciset.view.fragments;

import android.support.v4.app.Fragment;

import com.example.wojder.exerciset.view.fragments.CalculatorFragment;
import com.example.wojder.exerciset.view.fragments.DownloapptorFragment;
import com.example.wojder.exerciset.view.fragments.NotificapptorFragment;

/**
 * Created by wojder on 24.02.16.
 */
public enum ContentFragment {

    calculator(new CalculatorFragment()),
    downloader(new DownloapptorFragment()),
    notifapptor(new NotificapptorFragment());


    private Fragment fragment;

    ContentFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
