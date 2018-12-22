package com.example.cloudymous.footballclubcloud.view.player

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Player
import com.example.cloudymous.footballclubcloud.presenter.PlayersPresenter
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.example.cloudymous.footballclubcloud.view.player.detailplayer.DetailPlayerActivity
import com.example.cloudymous.footballclubcloud.view.teams.detailteam.DetailTeamActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_player_list.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class TeamPlayerFragment : Fragment(), TeamPlayerView {

    private var players: MutableList<Player> = mutableListOf()

    private lateinit var presenter: PlayersPresenter
    private lateinit var adapter: TeamPlayerAdapter
    private lateinit var teamId: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = TeamPlayerAdapter(requireContext(), players) {
            requireContext().startActivity<DetailPlayerActivity>(
                "playerId" to "${it.playerId}"
            )
        }

        player_list.layoutManager = LinearLayoutManager(context)
        player_list.adapter = adapter

        teamId = (activity as DetailTeamActivity).getTeamId()

        val request = ApiRepository()
        val gson = Gson()

        presenter = PlayersPresenter(this, request, gson)

        presenter.getTeamPlayers(teamId)

        swipe_refresh.onRefresh {
            presenter.getTeamPlayers(teamId)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_player_list, container, false)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showPlayerDetail(data: List<Player>) {
        swipe_refresh.isRefreshing = false
        players.clear()
        players.addAll(data)
        adapter.notifyDataSetChanged()
    }

}