package com.example.cloudymous.footballclubcloud.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.cloudymous.footballclubcloud.R.id.*
import com.example.cloudymous.footballclubcloud.view.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class AppImplementationTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HomeActivity::class.java)


    @Test
    fun testDetailMatchBehaviour() {

        Thread.sleep(5000)
        onView(withId(last_match_list))
            .check(matches(isDisplayed()))

        onView(withId(last_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        onView(withId(last_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        Thread.sleep(5000)

        onView(withId(home_badge))
            .check(matches(isDisplayed()))

        onView(withId(away_badge))
            .check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun testLastMatchBehaviour() {

        Thread.sleep(5000)
        onView(withId(last_match_list))
            .check(matches(isDisplayed()))

        onView(withId(last_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        onView(withId(last_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click())
        )

        onView(withId(add_to_favorite))
            .check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun testFavoriteBehaviour() {
        onView(withId(bottom_navigation))
            .check(matches(isDisplayed()))

        onView(withId(favorites)).perform(click())

        Thread.sleep(5000)
        onView(withId(favorite_match_list))
            .check(matches(isDisplayed()))

        onView(withId(favorite_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        onView(withId(favorite_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        pressBack()

    }

    @Test
    fun testNextMatchBehaviour() {
        onView(withId(bottom_navigation))
            .check(matches(isDisplayed()))

        onView(withId(next_match)).perform(click())

        Thread.sleep(5000)
        onView(withId(next_match_list))
            .check(matches(isDisplayed()))

        onView(withId(next_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        onView(withId(next_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(add_to_favorite))
            .check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        pressBack()


    }
}