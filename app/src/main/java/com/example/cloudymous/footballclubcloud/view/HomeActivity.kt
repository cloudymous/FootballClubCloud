package com.example.cloudymous.footballclubcloud.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.R.id.*
import com.example.cloudymous.footballclubcloud.R.layout.activity_home
import com.example.cloudymous.footballclubcloud.pageradapter.FavoritesFragment
import com.example.cloudymous.footballclubcloud.pageradapter.MatchScheduleFragment
import com.example.cloudymous.footballclubcloud.view.teams.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                match_list_fragment -> {
                    loadMatchFragment(savedInstanceState)
                }

                team_list_fragment -> {
                    loadNextMatchFragment(savedInstanceState)
                }

                favorites_fragment -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = match_list_fragment
    }


    private fun loadMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_container,
                    MatchScheduleFragment(), MatchScheduleFragment::class.java.simpleName
                ).commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_container,
                    TeamsFragment(), TeamsFragment::class.java.simpleName
                ).commit()
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_container,
                    FavoritesFragment(), FavoritesFragment::class.java.simpleName
                ).commit()
        }
    }
}
