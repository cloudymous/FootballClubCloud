package com.example.cloudymous.footballclubcloud.view.teams.detailteam

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.presenter.DetailTeamPresenter
import com.example.cloudymous.footballclubcloud.view.pageradapter.DetailTeamPagerAdapter
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity(), DetailTeamView {

    private lateinit var presenter: DetailTeamPresenter
//    private lateinit var team: Team

    private lateinit var teamId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        supportActionBar?.title = "Team Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        teamId = intent.getStringExtra("teamId")

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailTeamPresenter(this, request, gson)
        presenter.getDetailTeam(teamId)

        team_pager_main.adapter = DetailTeamPagerAdapter(supportFragmentManager)
        tabs_team.setupWithViewPager(team_pager_main)


    }

    fun getTeamId(): String {
        return teamId
    }

    override fun showTeamDetail(data: List<Team>) {
        Picasso.get().load(data[0].teamBadge).into(team_badge)
        team_name.text = data[0].teamName
        team_formed_year.text = data[0].teamFormatYear
        team_stadium.text = data[0].teamStadium
    }
}
