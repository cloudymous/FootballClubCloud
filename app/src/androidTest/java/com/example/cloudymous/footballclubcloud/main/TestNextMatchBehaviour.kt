package com.example.cloudymous.footballclubcloud.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.view.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class TestNextMatchBehaviour {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testNextMatchBehaviour() {
        onView(withId(R.id.bottom_navigation))
            .check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.next_match)).perform(ViewActions.click())

        delay()
        onView(withId(R.id.next_match_list))
            .check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.next_match_list))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        onView(withId(R.id.next_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click())
        )

        delay()
        onView(withId(R.id.add_to_favorite))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.add_to_favorite)).perform(ViewActions.click())

        pressBack()


    }

    private fun delay() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}