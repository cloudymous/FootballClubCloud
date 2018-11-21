package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.view.nextmatch.NextMatchView
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
                DetailMatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showNextMatchList(data.events)
            }
        }
    }
}