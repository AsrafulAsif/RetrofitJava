package com.example.retrofitjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {
    @GET("/photos")
    Call<List<userModel>> getUser();

}
