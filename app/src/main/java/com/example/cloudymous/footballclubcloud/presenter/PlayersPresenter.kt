package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.PlayerResponse
import com.example.cloudymous.footballclubcloud.ui.view.TeamPlayerView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PlayersPresenter(
    private val view: TeamPlayerView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamPlayers(teamId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamPlayer(teamId)),
                PlayerResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showPlayerDetail(data.player)
            }
        }
    }
}