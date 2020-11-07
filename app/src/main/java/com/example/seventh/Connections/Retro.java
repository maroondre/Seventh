package com.example.seventh.Connections;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    public ApiCall retrofitBuilder(){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(ApiCall.url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiCall ApiCall = retrofit.create(ApiCall.class);

        return ApiCall;
    }

    public ApiCall retrofitTeam(){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(ApiCall.teamurl)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiCall ApiCall = retrofit.create(ApiCall.class);

        return ApiCall;
    }

    public ApiCall retrofitTeams(){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(ApiCall.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiCall ApiCall = retrofit.create(ApiCall.class);

        return ApiCall;
    }
    
}
