package com.example.sshong.bunch;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by sshong on 12/6/16.
 */
public class MainLogin extends FragmentActivity {
    private TextView mTextDetails;
    private CallbackManager mCallbackManager;

//    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
//        @Override
//        public void onSuccess(LoginResult loginResult) {
//            AccessToken accessToken = loginResult.getAccessToken();
//            Profile profile = Profile.getCurrentProfile();
//            if (profile != null){
//                mTextDetails.setText("Welcome " + profile.getName());
//            }
//        }
//
//        @Override
//        public void onCancel() {
//
//        }
//
//        @Override
//        public void onError(FacebookException e) {
//
//        }
//    };

    public MainLogin(){

    }

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();

    }

    @Override

//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//       return inflater.inflate(R.layout.com_facebook_login_fragment,container,false);
//    }

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash, container, false);

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                AccessToken accessToken = loginResult.getAccessToken();

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });


//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState){
//        super.onViewCreated(view,savedInstanceState);
//        LoginButton loginButton = (LoginButton) view.findViewById(R.id.button);
//        loginButton.setReadPermissions("user-friends");
//        loginButton.setFragment(this);
//        loginButton.registerCallback(mCallbackManager,mCallback);
//    }

    public void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        mCallbackManager.onActivityResult(requestCode,resultCode,data);

    }

}
