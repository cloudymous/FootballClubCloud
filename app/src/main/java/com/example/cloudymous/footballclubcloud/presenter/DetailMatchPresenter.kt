package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.model.TeamResponse
import com.example.cloudymous.footballclubcloud.view.details.DetailMatchView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailMatchPresenter(
    private val view: DetailMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getDetailMatch(eventId: String?) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getDetailMatch(eventId)).await(),
                DetailMatchResponse::class.java
            )

            view.showTeam(data.events)
            view.hideLoading()
        }
    }

    fun getTeamBadge(homeTeamId: String?, awayTeamId: String?) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val homeBadge = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(homeTeamId)).await(),
                TeamResponse::class.java
            )

            val awayBadge = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(awayTeamId)).await(),
                TeamResponse::class.java
            )

            view.showBadge(homeBadge.teams, awayBadge.teams)
            view.hideLoading()
        }
    }
}