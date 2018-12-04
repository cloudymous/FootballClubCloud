package com.example.cloudymous.footballclubcloud.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.view.HomeActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class TestNextMatchBehaviour {

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
    fun testNextMatchBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.next_match_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        Thread.sleep(5000)

        Espresso.onView(ViewMatchers.withId(R.id.next_match_list))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        Espresso.onView(ViewMatchers.withId(R.id.next_match_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click())
        )

        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite)).perform(ViewActions.click())

        Espresso.pressBack()


    }
}