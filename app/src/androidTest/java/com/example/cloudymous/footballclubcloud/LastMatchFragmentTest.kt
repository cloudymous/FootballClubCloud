package com.example.cloudymous.footballclubcloud

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.cloudymous.footballclubcloud.R.id.*
import com.example.cloudymous.footballclubcloud.view.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class LastMatchFragmentTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testAppBehaviour() {

        onView(withId(last_match_list))
            .check(matches(isDisplayed()))

        onView(withId(last_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        onView(withId(last_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click())
        )

        onView(withId(add_to_favorite))
            .check(matches(isDisplayed()))

        onView(withId(add_to_favorite)).perform(click())

        onView(withText("Add to favorite"))
            .check(matches(isDisplayed()))
        pressBack()

        onView(withId(bottom_navigation))
            .check(matches(isDisplayed()))

        onView(withId(favorites)).perform(click())

    }
}