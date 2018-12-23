package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.PlayerDetailResponse
import com.example.cloudymous.footballclubcloud.view.DetailPlayerView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPlayerPresenter(
    private val view: DetailPlayerView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getPlayerDetail(playerId: String?) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getPlayerDetail(playerId)),
                PlayerDetailResponse::class.java
            )

            uiThread {
                view.showPlayerDetail(data.players)
            }
        }
    }
}