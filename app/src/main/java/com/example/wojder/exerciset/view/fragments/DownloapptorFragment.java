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

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloapptorFragment extends Fragment {

    private Button parseButton;
    private ListView topAppsList;
    private TextView title;

    public DownloapptorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View downloapptorView = inflater.inflate(R.layout.fragment_downloapptor, container, false);

        final DownloadData downloadData = new DownloadData();
        String url = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml";
        downloadData.execute(url);

        parseButton = (Button) downloapptorView.findViewById(R.id.btnParse);
        topAppsList = (ListView) downloapptorView.findViewById(R.id.appsListView);
        title = (TextView) downloapptorView.findViewById(R.id.topAppsTitle);
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
