package com.example.cloudymous.footballclubcloud.view.teams.detailteam

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.view.pageradapter.DetailTeamPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        supportActionBar?.title = "Team Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        team_pager_main.adapter = DetailTeamPagerAdapter(supportFragmentManager)
        tabs_team.setupWithViewPager(team_pager_main)


    }
}
