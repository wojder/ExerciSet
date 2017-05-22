package com.example.wojder.exerciset.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.model.Application;
import com.example.wojder.exerciset.utils.DownloadData;
import com.example.wojder.exerciset.utils.ParseApplication;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloapptorFragment extends Fragment {

    @Bind(R.id.btnParse) Button parseButton;
    @Bind(R.id.appsListView) ListView topAppsList;
    @Bind(R.id.topAppsTitle) TextView title;

    public DownloapptorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View downloapptorView = inflater.inflate(R.layout.fragment_downloapptor, container, false);

        ButterKnife.bind(this, downloapptorView);
        final DownloadData downloadData = new DownloadData();
        String url = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml";
//        String url = "https://api.flickr.com/services/feeds/photos_public.gne?tags";
        downloadData.execute(url);

        title.setText(R.string.top_apps_title);
        title.setVisibility(View.GONE);

        parseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setVisibility(View.VISIBLE);

                ParseApplication parseApplication = new ParseApplication(downloadData.getmFileContents());
                parseApplication.process();

                ArrayAdapter<Application> adapter = new ArrayAdapter<Application>(getActivity(), R.layout.apps_list_item, parseApplication.getApplications());

                topAppsList.setAdapter(adapter);
            }
        });
        return downloapptorView;
    }
}
