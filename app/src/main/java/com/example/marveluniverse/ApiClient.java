package com.example.marveluniverse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiClient {
    @GET("/v1/public/characters")
    Call<gSonmodal> getData(@Query("q")String vale);
}
