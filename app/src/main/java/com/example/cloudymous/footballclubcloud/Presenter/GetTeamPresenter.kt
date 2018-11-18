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

    fun getTeamDetail(teamHomeName: String?, teamAwayName: String?){
        view.showLoading()
        doAsync {
            val dataHome = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamHomeName)),
                TeamResponse::class.java)

            val dataAway = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamAwayName)),
                TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeam(dataHome.teams, dataAway.teams)
            }
        }
    }

}