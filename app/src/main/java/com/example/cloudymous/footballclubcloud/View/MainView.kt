package com.example.cloudymous.footballclubcloud.View

import com.example.cloudymous.footballclubcloud.Model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}