package com.example.cloudymous.footballclubcloud.view.player

import com.example.cloudymous.footballclubcloud.model.Player

interface TeamPlayerView {
    fun showLoading()
    fun hideLoading()
    fun showPlayerDetail(data: List<Player>)
}