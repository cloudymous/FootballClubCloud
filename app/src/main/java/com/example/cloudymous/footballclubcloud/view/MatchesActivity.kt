package com.example.cloudymous.footballclubcloud.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.synthetic.main.main_matches_fragment.*

class MatchesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_matches_fragment)

        matches_pager_main.adapter = MainPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(matches_pager_main)

    }
}