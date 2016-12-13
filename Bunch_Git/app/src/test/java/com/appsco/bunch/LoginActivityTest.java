package com.appsco.bunch.test;

import android.content.Intent;

import com.appsco.bunch.BuildConfig;
import com.appsco.bunch.LoginActivity;
import com.appsco.bunch.MainActivity;
import com.appsco.bunch.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

/**
 * Created by ellenlowing on 12/12/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginActivityTest {
/*    @Test
    public void onCreate() throws Exception {

    }
*/
    @Test
    public void onClick() throws Exception {
/*        //Test for buttonSignin
        LoginActivity activity1 = Robolectric.setupActivity(LoginActivity.class);
        activity1.findViewById(R.id.buttonSignin).performClick();

        Intent expectedIntent = new Intent(activity1, ProfileActivity.class);
        ShadowActivity shadowActivity = Shadows.shadowOf(activity1);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
*/
        //Test for textViewSignUp, checks if it goes to MainActivity
        LoginActivity activity2 = Robolectric.setupActivity(LoginActivity.class);
        activity2.findViewById(R.id.textViewSignUp).performClick();

        Intent expectedIntent2 = new Intent(activity2, MainActivity.class);
        ShadowActivity shadowActivity2 = Shadows.shadowOf(activity2);
        Intent actualIntent2 = shadowActivity2.getNextStartedActivity();
        assertTrue(actualIntent2.filterEquals(expectedIntent2));

    }

}