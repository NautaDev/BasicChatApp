package com.oncodemy.basicchatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    // You know, this is used for logging purposes!
    static final String TAG = ChatActivity.class.getSimpleName();

    static final String USER_ID_KEY = "userId";
    static final String BODY_KEY = "body";

    // UI vars:
    EditText etxt_Message;
    Button btn_Send;
    RecyclerView rView_Messages;

    // RecyclerView vars:
    ArrayList<Message> rvMessages;
    ChatAdapter rvAdapter;

    // Keep track of initial load to scroll to the bottom of the ListView
    boolean aFirstLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // For now we will use the anonymous login, maybe later I update the app to use
        // accounts, but right now this is a basic and simple app
        if (ParseUser.getCurrentUser() != null) { // If we have already an user
            startWithCurrentUser(); // We start with it
        } else { // If not logged in, login as a new anonymous user
            login();
        }
    }

    // Function: Get the userId from the cached currentUser object
    void startWithCurrentUser() {
        setupMessagePosting();
    }

    // Function: Setup button event handler which posts the entered message to Parse
    void setupMessagePosting() {
        // Assign the UI vars
        etxt_Message = (EditText) findViewById(R.id.aC_etxt_Message);
        btn_Send = (Button) findViewById(R.id.aC_btn_Send);
        rView_Messages = (RecyclerView) findViewById(R.id.aC_rView_Messages);

        // Set up the vars used by the recycler view
        rvMessages = new ArrayList<>();
        final String userId = ParseUser.getCurrentUser().getObjectId();
        rvAdapter = new ChatAdapter(ChatActivity.this, userId, rvMessages);
        rView_Messages.setAdapter(rvAdapter);

        // And the vars used by the activity
        aFirstLoad = true;

        // We have to associate the LayoutManager with the RecyclerView
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatActivity.this);
        rView_Messages.setLayoutManager(linearLayoutManager);

        // Now let's configure what happens when the send button is clicked
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // First we get the message (it is in the message edit text)
                String data = etxt_Message.getText().toString();

                // We will use the Message subclass we created
                Message message=new Message();
                // We assign the message the user has written
                message.setBody(data);
                // And we assign the user id we are using (right now it is an anonymous one, later maybe it will be a registered user)
                message.setUserId(ParseUser.getCurrentUser().getObjectId());

                // Now we save the message (sending it to server if it is possible!)
                message.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null) {
                            Toast.makeText(ChatActivity.this, getString(R.string.toast_saved_message_ok),
                                    Toast.LENGTH_SHORT).show();
                            refreshMessages();
                        } else {
                            Log.e(TAG, getString(R.string.toast_saved_message_err), e);
                        }
                    }
                });

                // And finally, just empty the input field to make the life of our loved user easier
                etxt_Message.setText(null);
            }
        });
    }

    // Function:
    void refreshMessages(){
        // TODO
    }

    // Function: Easy, create an anonymous user using ParseAnonymousUtils and set sUserId
    void login() {
        ParseAnonymousUtils.logIn(new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Anonymous login failed: ", e);
                } else {
                    startWithCurrentUser();
                }
            }
        });
    }
}
