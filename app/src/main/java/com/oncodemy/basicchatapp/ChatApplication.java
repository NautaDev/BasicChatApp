package com.oncodemy.basicchatapp;

import android.app.Application;

import com.parse.Parse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class ChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Use for monitoring Parse network traffic
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // We have to create a Parse Configuration Builder to setup our app data
        Parse.Configuration.Builder confBuilder=new Parse.Configuration.Builder(this);
        confBuilder.server(getString(R.string.back4app_server_url));
        confBuilder.applicationId(getString(R.string.back4app_app_id));
        confBuilder.clientKey(getString(R.string.back4app_client_key));
        confBuilder.enableLocalDataStore();

        Parse.enableLocalDatastore(this);

        // Now we can create the var with the Parse configuration:
        Parse.Configuration parseConf=confBuilder.build();

        // And we can initialize Parse:
        Parse.initialize(parseConf);

    }
}
