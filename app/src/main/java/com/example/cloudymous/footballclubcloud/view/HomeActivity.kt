package com.example.cloudymous.footballclubcloud.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.R.id.*
import com.example.cloudymous.footballclubcloud.R.layout.activity_home
import com.example.cloudymous.footballclubcloud.view.fragment.FavoriteTeamFragment
import com.example.cloudymous.footballclubcloud.view.lastmatch.LastMatchFragment
import com.example.cloudymous.footballclubcloud.view.fragment.NextMatchFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                last_match -> {
                    loadLastMatchFragment(savedInstanceState)
                }

                next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }

                favorites -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = last_match
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,
                    LastMatchFragment(), LastMatchFragment::class.java.simpleName).commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,
                    NextMatchFragment(), NextMatchFragment::class.java.simpleName).commit()
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,
                    FavoriteTeamFragment(), FavoriteTeamFragment::class.java.simpleName).commit()
        }
    }
}
