package com.example.simplebackgroundtask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Creating the Retrofit Instance
public class ApiClient {
    private static final String url = "https://gorest.co.in/public/v2/";

    private static Retrofit retrofit;

    public static ApiInterface getAPI() { // cái ta trả về
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit.create(ApiInterface.class);
    }
}
