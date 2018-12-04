package com.example.cloudymous.footballclubcloud.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.cloudymous.footballclubcloud.R.id.*
import com.example.cloudymous.footballclubcloud.view.HomeActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class TestDetailMatchBehaviour {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun testAppContext() {
        val mainActivityIdlingResource: CountingIdlingResource =
            activityRule.activity.getEspressoIdlingResourceHomeActivity()
        IdlingRegistry.getInstance().register(mainActivityIdlingResource)
    }


    @Test
    fun testDetailMatchBehaviour() {

//        Thread.sleep(3000)
        onView(withId(last_match_list))
            .check(matches(isDisplayed()))

        onView(withId(last_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))

        onView(withId(last_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click())
        )

//        Thread.sleep(5000)

        onView(withId(home_badge))
            .check(matches(isDisplayed()))

        onView(withId(away_badge))
            .check(matches(isDisplayed()))

        onView(withId(team_home))
            .check(matches(isDisplayed()))

        onView(withId(team_away))
            .check(matches(isDisplayed()))

    }

}