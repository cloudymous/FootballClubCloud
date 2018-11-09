package com.example.cloudymous.footballclubcloud.View

import com.example.cloudymous.footballclubcloud.Model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}