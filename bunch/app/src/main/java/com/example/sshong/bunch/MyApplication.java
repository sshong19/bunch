package com.example.sshong.bunch;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

/**
 * Created by sshong on 12/6/16.
 */
public class MyApplication extends Application {
    //updated your class body;

    @Override
    public void onCreate(){
        super.onCreate();
        printHashkey();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    public void printHashkey(){
            // Add code to print out the key hash
            try {
                PackageInfo info = getPackageManager().getPackageInfo(
                        "com.example.sshong.bunch",
                        PackageManager.GET_SIGNATURES);
                for (android.content.pm.Signature signature : info.signatures) {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    Log.d("SSHONG", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                }
            } catch (PackageManager.NameNotFoundException e) {

            } catch (NoSuchAlgorithmException e) {

            }

        }
}
