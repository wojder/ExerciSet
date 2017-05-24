package com.example.wojder.exerciset.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wojder.exerciset.R;
import com.example.wojder.exerciset.model.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 24.05.17.
 */

public class FlickrAdapter extends RecyclerView.Adapter<FlickrViewHolder> {
    private List<Item> mItemList;
    private Context mContext;
    private static String TAG = "FlickrAdapter";

    public FlickrAdapter(List<Item> itemList, Context context) {
        this.mItemList = itemList;
        this.mContext = context;
    }

    @Override
    public FlickrViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flickr_item, null);

        FlickrViewHolder vh = new FlickrViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(FlickrViewHolder holder, int position) {

        Item photo = mItemList.get(position);
        Picasso
                .with(mContext)
                .load(photo.getLink())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.photoThumbnail);

        holder.photoTitle.setText(photo.getTitle());

        Log.d(TAG, "List size to show: " + mItemList.size());

    }

    @Override
    public int getItemCount() {
        return (null != mItemList ? mItemList.size() : 0);
    }
}
