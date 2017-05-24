package com.example.wojder.exerciset.view.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.utils.NotificappService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificapptorFragment extends Fragment {

    @BindView(R.id.btn_notify_me)
    Button buttonNotifyMe;
    @BindView(R.id.notificapp_instruction)
    TextView tvNotificapp;

    @OnClick(R.id.btn_notify_me)
    public void notifyMe() {
        Intent notifyIntent = new Intent(getContext(), NotificappService.class);

//        startActivity(notifyIntent);
        notifyIntent.setDataAndType(Uri.parse("https://www.dropbox.com/s/6z4dux5lzs431i2/PawelWojderaResume.pdf?dl=0"), "application/pdf");

        getActivity().startService(notifyIntent);
    }

    public NotificapptorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View notificappView = inflater.inflate(R.layout.fragment_notificapptor, container, false);
        ButterKnife.bind(this, notificappView);

//        notifyMe();

        return notificappView;
    }
}
