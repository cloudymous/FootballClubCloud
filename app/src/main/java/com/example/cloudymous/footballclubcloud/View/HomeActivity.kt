package com.example.cloudymous.footballclubcloud.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.R.id.team
import com.example.cloudymous.footballclubcloud.R.layout.activity_home
import com.example.cloudymous.footballclubcloud.R.id.favorites
import com.example.cloudymous.footballclubcloud.View.Fragment.FavoriteTeamFragment
import com.example.cloudymous.footballclubcloud.View.Fragment.TeamFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                team -> {
                    loadTeamFragment(savedInstanceState)
                }
                favorites -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = team
    }

    private fun loadTeamFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,
                    TeamFragment(), TeamFragment::class.java.simpleName).commit()
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
