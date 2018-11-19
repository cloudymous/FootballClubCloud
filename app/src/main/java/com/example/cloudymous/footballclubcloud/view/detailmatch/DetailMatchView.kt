package com.example.cloudymous.footballclubcloud.view.detailmatch

import com.example.cloudymous.footballclubcloud.model.Team

interface DetailMatchView {

    fun showLoading()
    fun hideLoading()
    fun showTeam(dataHome: List<Team>, dataAway: List<Team>)
}