package com.example.wojder.exerciset.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.utils.ParseApplication;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wojder on 27.02.16.
 */
public class DownloapptorAdapter extends BaseAdapter {
    ViewHolder viewHolder;

    public DownloapptorAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    private final LayoutInflater inflater;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {


//        ParseApplication parseApplication = new ParseApplication(downloadData.getmFileContents());

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
           convertView = inflater.inflate(R.layout.fragment_downloapptor, parent, false);
            viewHolder = new ViewHolder(convertView);
        }


        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.btnParse)
        Button parseButton;
        @Bind(R.id.appsListView)
        ListView topAppsList;
        @Bind(R.id.topAppsTitle)
        TextView title;

        ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }

}
