package com.example.cloudymous.footballclubcloud.Presenter

import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.Model.NextMatchResponse
import com.example.cloudymous.footballclubcloud.View.NextMatch.NextMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter (private val view: NextMatchView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson
) {

    fun getNextMatch(leagueId: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(leagueId)),
                NextMatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showNextMatchList(data.events)
            }
        }
    }
}