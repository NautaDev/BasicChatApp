package com.oncodemy.basicchatapp;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Message")

// This class extends from ParseObject, will provide the message data when using it on the recycler view
// and will help us to retrieve and save messages to Parse
public class Message extends ParseObject {
    public static final String USER_ID_KEY = "userId";
    public static final String BODY_KEY = "body";

    public String getUserId() {
        return getString(USER_ID_KEY);
    }

    public String getBody() {
        return getString(BODY_KEY);
    }

    public void setUserId(String userId) {
        put(USER_ID_KEY, userId);
    }

    public void setBody(String body) {
        put(BODY_KEY, body);
    }
}
