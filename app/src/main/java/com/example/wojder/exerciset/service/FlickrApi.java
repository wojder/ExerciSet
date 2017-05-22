package com.example.wojder.exerciset.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wojder on 22.05.17.
 */

public interface FlickrApi {
    @GET("services/feeds/photos_public.gne?")
    Call<ResponseBody> getFlicrkResponse(@Query("format") String format,
                                         @Query("tags") String tags,
                                         @Query("nojsoncallback") int nojsoncallback);


}
