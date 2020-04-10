package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalendarEventsTests extends AbstractTestBase {




        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        /**
         * Test Case: Default options
         * Login as sales manager
         * Go to Activities --> Calendar Events
         * Click on Create Calendar Event
         * Default owner name should be current user/
         **/

        @Test
        public void defaultOptionsTest() {
            loginPage.login();
            calendarEventsPage.navigateTo("Activities", "Calendar Events");
            calendarEventsPage.clickToCreateCalendarEvent();
            Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());

            String actualStartDate = calendarEventsPage.getStartDate();
            String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");

            Assert.assertEquals(actualStartDate, expectedStartDate);

        }

    /**
     * 15 minutes until 3:45
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/

    @Test
    public void TimeDifference(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();



    }







}









