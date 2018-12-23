package com.example.cloudymous.footballclubcloud.ui.view

import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.model.Team

interface DetailMatchView {

    fun showLoading()
    fun hideLoading()
    fun showTeam(data: List<DetailMatch>)
    fun showBadge(dataHome: List<Team>, dataAway: List<Team>)
}