package com.example.wojder.exerciset.service;

import android.util.Log;

import com.example.wojder.exerciset.model.pojo.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 22.05.17.
 */

public class FlickrJsonParser {

    private final String FLICKR_ITEMS = "items";
    private final String PHOTO_LINK = "link";
    private final String PHOTO_TITLE = "title";
    private final String PHOTO_TAGS = "tags";
    private final String PHOTO_AUTHOR = "author";
    private final String PHOTO_DESC = "description";
    private final String MEDIA_URL = "m";
    private final String MEDIA = "media";
//    private final String PHOTO_URL = "url";

    public static final String TAG = "FlickrParser";
    private String baseUrl = "https://api.flickr.com/";

    private ArrayList<Item> items = new ArrayList<>();

    public FlickrJsonParser() {
    }

    public void processFlickrData() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final FlickrApi flickrApi = retrofit.create(FlickrApi.class);
        retrofit2.Call<ResponseBody> response = flickrApi.getFlicrkResponse("json", "android, oreo", 1);

        response.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                int responseCode = response.code();

                if (responseCode == 200) {
                    try {
                        byte[] jsonByte = response.body().bytes();
                        String flickrJson = new String(jsonByte);

                        if (!flickrJson.isEmpty()) {

                            JSONObject jsonObject = new JSONObject(flickrJson);
                            Log.d(TAG, "JSON looks like: " + flickrJson);
                            JSONArray itemsArray = jsonObject.getJSONArray(FLICKR_ITEMS);

                            for (int i = 0; i < itemsArray.length(); i++) {

                                JSONObject flickrPhoto = itemsArray.getJSONObject(i);
                                String title = flickrPhoto.getString(PHOTO_TITLE);
                                String link = flickrPhoto.getString(PHOTO_LINK);
                                String author = flickrPhoto.getString(PHOTO_AUTHOR);
                                String description = flickrPhoto.getString(PHOTO_DESC);
                                String tags = flickrPhoto.getString(PHOTO_TAGS);
//                            String url = flickrPhoto.getString(PHOTO_URL);

                                JSONObject flickrMedia = flickrPhoto.getJSONObject(MEDIA);
                                String media_url = flickrMedia.getString(MEDIA_URL);

                                Item flickr_item = new Item(title, media_url, description, author, tags);
                                items.add(flickr_item);
                            }
                        }
                        Log.d(TAG, "number of items: " + items.size());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }
            }


            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "Failed response from server");
            }
        });
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
