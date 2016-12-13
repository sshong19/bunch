package com.appsco.bunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Created by ellenlowing on 12/12/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class UserTest {
    //Create an user object on heap
    User testUser = new User();

    //Test checking setFirstName() function of User class
    @Test
    public void setFirstName() throws Exception {
        String expected = "Ellen";
        testUser.setFirstName(expected);
        assertEquals(expected,testUser.firstName);
    }

    //Test checking setLastName() function of User class
    @Test
    public void setLastName() throws Exception {
        String expected = "Lo";
        testUser.setLastName(expected);
        assertEquals(expected,testUser.lastName);
    }

    //Test checking setCollege() function of User class
    @Test
    public void setCollege() throws Exception {
        String expected = "BU";
        testUser.setCollege(expected);
        assertEquals(expected,testUser.college);
    }

    //Test checking setMajor() function of User class
    @Test
    public void setMajor() throws Exception {
        String expected = "ENG";
        testUser.setMajor(expected);
        assertEquals(expected,testUser.major);
    }

    //Test checking setYear() function of User class
    @Test
    public void setYear() throws Exception {
        String expected = "2019";
        testUser.setYear(expected);
        assertEquals(expected,testUser.year);
    }

}