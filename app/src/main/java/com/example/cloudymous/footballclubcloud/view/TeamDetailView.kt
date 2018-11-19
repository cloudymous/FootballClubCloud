package com.example.cloudymous.footballclubcloud.view

import com.example.cloudymous.footballclubcloud.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}