package com.example.cloudymous.footballclubcloud.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.presenter.TeamsPresenter
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.example.cloudymous.footballclubcloud.view.teams.TeamView
import com.example.cloudymous.footballclubcloud.view.teams.TeamsAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_team_list.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast

class TeamsListFragment : Fragment(), TeamView {

    private var teams: MutableList<Team> = mutableListOf()
    private lateinit var presenter: TeamsPresenter
    private lateinit var adapter: TeamsAdapter
    private lateinit var leagueName: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        league_spinner_team.adapter = spinnerAdapter

        adapter = TeamsAdapter(requireContext(), teams) {
            //            context?.startActivity<TeamDetailActivity>("id" to "${it.teamId}")
            toast("Hello").show()
        }
        team_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamsPresenter(this, request, gson)
        league_spinner_team.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                leagueName = league_spinner_team.selectedItem.toString()
                presenter.getTeams(leagueName)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        swipe_refresh.onRefresh {
            presenter.getTeams(leagueName)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_team_list, container, false)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showTeamList(data: List<Team>) {
        swipe_refresh.isRefreshing = false
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }

}