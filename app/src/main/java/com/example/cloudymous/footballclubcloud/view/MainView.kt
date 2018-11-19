package com.example.cloudymous.footballclubcloud.view

import com.example.cloudymous.footballclubcloud.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}