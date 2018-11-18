package com.example.cloudymous.footballclubcloud.Presenter

import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.Model.TeamResponse
import com.example.cloudymous.footballclubcloud.View.DetailMatch.DetailMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class GetTeamPresenter (private val view: DetailMatchView,
                        private val apiRepository: ApiRepository,
                        private val gson: Gson) {

    fun getTeamDetail(teamHomeId: String?, teamAwayId: String?){
        view.showLoading()
        doAsync {
            val dataTeamHome = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamHomeId)),
                TeamResponse::class.java)

            val dataTeamAway = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamAwayId)),
                TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeam(dataTeamHome.teams, dataTeamAway.teams)
            }
        }
    }

}