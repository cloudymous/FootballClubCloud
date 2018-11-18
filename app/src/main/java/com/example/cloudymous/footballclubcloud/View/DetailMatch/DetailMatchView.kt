package com.example.cloudymous.footballclubcloud.View.DetailMatch

import com.example.cloudymous.footballclubcloud.Model.Team

interface DetailMatchView {

    fun showLoading()
    fun hideLoading()
    fun showTeam(dataHome: List<Team>, dataAway: List<Team>)
}