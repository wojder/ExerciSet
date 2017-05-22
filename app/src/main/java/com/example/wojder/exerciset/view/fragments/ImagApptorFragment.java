package com.example.wojder.exerciset.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.service.FlickrJsonParser;

import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagApptorFragment extends Fragment {
    private final String TAG = "Flickr";

    public ImagApptorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlickrJsonParser flickrJsonParser = new FlickrJsonParser();
        flickrJsonParser.processFlickrData();

//        Log.d(TAG, "Created url: " + flickrJsonParser.processFlickrData());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View imagapptorView = inflater.inflate(R.layout.fragment_imag_apptor, container, false);
        return imagapptorView;
    }

}
