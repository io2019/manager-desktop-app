package controllers;

import api.APIService;
import api.BasicAuthInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController {
    public static APIService api;
    public static String username;


    public static void build(String user, String pass) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(user, pass));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://127.0.0.1:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        api = retrofit.create(APIService.class);
        username = user;
    }

    public APIController() {}
}
