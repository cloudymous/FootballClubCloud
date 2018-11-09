package com.example.cloudymous.footballclubcloud.Presenter

import android.view.View
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.Model.TeamResponse
import com.example.cloudymous.footballclubcloud.View.TeamDetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamList(teamId: String) {
        view.showLoading()
        doAsync {
            val data =
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamDetail(teamId)), TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}