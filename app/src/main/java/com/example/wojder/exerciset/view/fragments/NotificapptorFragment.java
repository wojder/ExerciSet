package com.example.wojder.exerciset.view.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.utils.NotificappService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificapptorFragment extends Fragment {

    @Bind(R.id.btn_notify_me) Button buttonNotifyMe;
    @Bind(R.id.notificapp_instruction) TextView tvNotificapp;

    @OnClick(R.id.btn_notify_me)
    public void notifyMe(){
        Intent notifyIntent = new Intent(getActivity(), NotificappService.class);

        notifyIntent.setDataAndType(Uri.parse("http://commonsware.com/Android/excerpt.pdf"), "application/pdf");

        getActivity().startService(notifyIntent);
        getActivity().finish();
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

        notifyMe();

        return notificappView;
    }

}
