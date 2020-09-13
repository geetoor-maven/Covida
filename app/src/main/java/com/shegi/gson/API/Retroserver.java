package com.shegi.gson.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * created by shegi-developer on 05/07/20
 */
public class Retroserver {
    private static final String URL = "https://api.kawalcorona.com/";

    private static Retrofit retrofit;
    public static Retrofit GetClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
