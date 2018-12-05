package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.view.matches.lastmatch.LastMatchView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LastMatchPresenter(
    private val view: LastMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getLastMatch(leagueId: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getLastMatch(leagueId)).await(),
                DetailMatchResponse::class.java
            )

            view.showLastMatchList(data.events)
            view.hideLoading()
        }
    }
}