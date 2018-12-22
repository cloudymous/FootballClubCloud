package com.example.cloudymous.footballclubcloud.view.teams.player

import com.example.cloudymous.footballclubcloud.model.Player

interface TeamPlayerView {
    fun showPlayerDetail(data: List<Player>)
}