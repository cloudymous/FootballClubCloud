package com.example.cloudymous.footballclubcloud.Presenter

import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.Model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.View.DetailMatch.DetailMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailMatchPresenter (private val view: DetailMatchView,
                            private val apiRepository: ApiRepository,
                            private val gson: Gson) {

    fun getMatchDetail(matchId: String?){
//        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getMatchDetail(matchId)),
                DetailMatchResponse::class.java
            )

            uiThread {
//                view.hideLoading()
                view.showDetailMatch(data.events)
            }
        }

    }
}