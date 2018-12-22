package com.example.cloudymous.footballclubcloud.view.teams.detailteam

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Player
import com.example.cloudymous.footballclubcloud.presenter.PlayersPresenter
import com.google.gson.Gson

class DetailTeamPlayerFragment : Fragment(), DetailTeamPlayerView {

    private var players: MutableList<Player> = mutableListOf()
    private lateinit var presenter: PlayersPresenter
    private lateinit var adapter: DetailTeamPlayerAdapter
    private lateinit var playerId: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = DetailTeamPlayerAdapter(requireContext(), players) {
            requireContext(),
        }

        val request = ApiRepository()
        val gson = Gson()
    }

    override fun showPlayerDetail(data: List<Player>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}