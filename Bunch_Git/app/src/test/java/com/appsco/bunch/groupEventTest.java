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
public class groupEventTest {

    groupEvent testGroup = new groupEvent("ellen", "EC327", "01/01/16", 3.0f, "8", "Ingalls", "15:00");

    @Test
    public void getCourse() throws Exception {
        String expected = "EC327";

        assertEquals(expected,testGroup.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        String expected = "CH101";
        testGroup.setCourse(expected);
        assertEquals(expected,testGroup.getCourse());

    }

    @Test
    public void getDate() throws Exception {
        String expected = "01/01/16";
        assertEquals(expected,testGroup.getDate());

    }

    @Test
    public void getMaximumppl() throws Exception {
        String expected = "8";
        assertEquals(expected,testGroup.getMaximumppl());

    }

    @Test
    public void setMaximumppl() throws Exception{
        String expected = "5";
        testGroup.setMaximumppl(expected);
        assertEquals(expected,testGroup.getMaximumppl());
    }

    @Test
    public void getTime() throws Exception {
        String expected = "15:00";
        assertEquals(expected,testGroup.getTime());
    }

    @Test
    public void setTime() throws Exception {
        String expected = "17:00";
        testGroup.setTime(expected);
        assertEquals(expected,testGroup.getTime());
    }
/*
    @Test
    public void getFirstName() throws Exception {
        String expected = "ellen";
        assertEquals(expected,testGroup.getFirstName());

    }
*/
    @Test
    public void setFirstName() throws Exception {
        String expected = "Ellen";
        testGroup.setFirstName(expected);
        assertEquals(expected,testGroup.getFirstName());
    }

    @Test
    public void getLocation() throws Exception {
        String expected = "Ingalls";
        assertEquals(expected,testGroup.getLocation());
    }

    @Test
    public void setLocation() throws Exception {
        String expected = "Myles";
        testGroup.setLocation(expected);
        assertEquals(expected,testGroup.getLocation());
    }
/*
    @Test
    public void getStartDate() throws Exception {

    }

    @Test
    public void setStartDate() throws Exception {

    }

    @Test
    public void getIntensity() throws Exception {
        Float expected = 3.0f;
        assertEquals(expected,testGroup.getIntensity());


    }

    @Test
    public void setIntensity() throws Exception {

    }

    @Test
    public void getMaxMembers() throws Exception {

    }

    @Test
    public void setMaxMembers() throws Exception {

    }
*/
}