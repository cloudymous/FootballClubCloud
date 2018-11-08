package com.example.cloudymous.footballclubcloud.View

import com.example.cloudymous.footballclubcloud.Model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}