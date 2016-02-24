package com.example.wojder.exerciset.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.view.fragments.CalculatorFragment;

/**
 * Created by wojder on 24.02.16.
 */
public class FragmentExchanger {

    private static FragmentExchanger instance;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;

    public static FragmentExchanger getInstance() {
        if (instance == null) {
            instance = new FragmentExchanger();
        }
        return instance;
    }

    private FragmentExchanger() {
    }

    public Fragment changeFragment(FragmentActivity context, Fragment content) {
        fragmentManager = context.getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (content instanceof CalculatorFragment) {
            ft.replace(R.id.content_view, content, "Calculator Fragment").commitAllowingStateLoss();
        } else {
            ft.replace(R.id.content_view, content, "Calculator Fragment").commitAllowingStateLoss();
        }

        currentFragment = content;

        return currentFragment;
    }

}
