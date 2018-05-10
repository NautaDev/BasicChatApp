package com.oncodemy.basicchatapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;



public class ChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Before anything else, we have to register the Message subclass (at least, before Parse.initialize)
        ParseObject.registerSubclass(Message.class);


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
