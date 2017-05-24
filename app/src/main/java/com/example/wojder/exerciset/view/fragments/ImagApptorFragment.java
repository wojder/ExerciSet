package com.example.wojder.exerciset.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.service.FlickrJsonParser;
import com.example.wojder.exerciset.view.adapters.FlickrAdapter;
import com.example.wojder.exerciset.view.adapters.FlickrViewHolder;

import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagApptorFragment extends Fragment {
    private final String TAG = "Flickr";
    private FlickrAdapter flickrAdapter;
    private RecyclerView recyclerView;
    private FlickrJsonParser flickrJsonParser = new FlickrJsonParser();

    public ImagApptorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        flickrJsonParser = new FlickrJsonParser();
        flickrJsonParser.processFlickrData();



//        Log.d(TAG, "Created url: " + flickrJsonParser.processFlickrData());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        flickrJsonParser.processFlickrData();

        View imagapptorView = inflater.inflate(R.layout.fragment_imag_apptor, container, false);
        flickrAdapter = new FlickrAdapter(flickrJsonParser.getItems(), getActivity().getApplicationContext());
        recyclerView = (RecyclerView) imagapptorView.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(flickrAdapter);
        recyclerView.invalidate();

        return imagapptorView;
    }
}
