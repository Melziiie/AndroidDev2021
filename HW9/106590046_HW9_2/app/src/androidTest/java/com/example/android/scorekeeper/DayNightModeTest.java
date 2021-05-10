package com.example.android.scorekeeper;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatDelegate;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Recorded Espresso test that tests the Day and Night Mode Options.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class DayNightModeTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Tests Night Mode.
     */
    @Test
    public void nightModeActive(){
        openActionBarOverflowOrOptionsMenu(mainActivityTestRule.getActivity());
        onView(withText(R.string.night_mode)).check(matches(isDisplayed()));
        onView(withText(R.string.night_mode)).perform(click());
        openActionBarOverflowOrOptionsMenu(mainActivityTestRule.getActivity());
        onView(withText(R.string.day_mode)).check(matches(isDisplayed()));
        onView(withText(R.string.day_mode)).perform(click());
        openActionBarOverflowOrOptionsMenu(mainActivityTestRule.getActivity());
        onView(withText(R.string.night_mode)).check(matches(isDisplayed()));
    }
}

