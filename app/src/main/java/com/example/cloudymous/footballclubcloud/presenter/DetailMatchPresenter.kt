package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.model.TeamResponse
import com.example.cloudymous.footballclubcloud.ui.view.DetailMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailMatchPresenter(
    private val view: DetailMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getDetailMatch(eventId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getDetailMatch(eventId)),
                DetailMatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeam(data.events)
            }


        }
    }

    fun getTeamBadge(homeTeamId: String?, awayTeamId: String?) {
        view.showLoading()
        doAsync {
            val homeBadge = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(homeTeamId)),
                TeamResponse::class.java
            )

            val awayBadge = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(awayTeamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showBadge(homeBadge.teams, awayBadge.teams)
            }


        }
    }
}