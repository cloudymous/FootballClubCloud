package com.example.cloudymous.footballclubcloud.Presenter

import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.Model.LastMatchResponse
import com.example.cloudymous.footballclubcloud.View.LastMatch.LastMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter (private val view: LastMatchView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getLastMatch(leagueId: String?){
//        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLastMatch(leagueId)),
                LastMatchResponse::class.java
            )

            uiThread {
//                view.hideLoading()
                view.showLastMatchList(data.events)
            }
        }
    }
}