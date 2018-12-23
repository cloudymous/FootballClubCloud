package com.example.cloudymous.footballclubcloud.view

import com.example.cloudymous.footballclubcloud.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}