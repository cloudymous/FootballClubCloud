package com.example.cloudymous.footballclubcloud.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.presenter.DetailTeamPresenter
import com.example.cloudymous.footballclubcloud.ui.activity.DetailTeamActivity
import com.example.cloudymous.footballclubcloud.ui.view.DetailTeamView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_team_overview.*

class DetailTeamOverviewFragment : Fragment(),
    DetailTeamView {

    private lateinit var presenter: DetailTeamPresenter
    private lateinit var teamId: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        teamId = (activity as DetailTeamActivity).getTeamId()

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailTeamPresenter(this, request, gson)
        presenter.getDetailTeam(teamId)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_team_overview, container, false)
    }

    override fun showTeamDetail(data: List<Team>) {
        team_overview.text = data[0].teamDescription
    }
}