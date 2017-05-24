package com.example.wojder.exerciset.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wojder.exerciset.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by root on 24.05.17.
 */

public class FlickrViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.photo_thumb)
    ImageView photoThumbnail;
    @BindView(R.id.photo_title)
    TextView photoTitle;

    public FlickrViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
