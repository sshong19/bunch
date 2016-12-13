package com.appsco.bunch;

import android.content.Intent;

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
public class MainActivityTest {
/**
    @Test
    public void onCreate() throws Exception {

    }
*/

    @Test
    public void onClick() throws Exception {
/*
        //Test for buttonRegister, check if it goes to ProfileActivity
        MainActivity activity1 = Robolectric.setupActivity(MainActivity.class);
        activity1.findViewById(R.id.buttonRegister).performClick();

        Intent expectedIntent = new Intent(activity1, ProfileActivity.class);
        ShadowActivity shadowActivity = Shadows.shadowOf(activity1);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
*/
        //Test for textViewSignin, check if it goes to LoginActivity
        MainActivity activity2 = Robolectric.setupActivity(MainActivity.class);
        activity2.findViewById(R.id.textViewSignin).performClick();

        Intent expectedIntent2 = new Intent(activity2, LoginActivity.class);
        ShadowActivity shadowActivity2 = Shadows.shadowOf(activity2);
        Intent actualIntent2 = shadowActivity2.getNextStartedActivity();
        assertTrue(actualIntent2.filterEquals(expectedIntent2));

    }

    }