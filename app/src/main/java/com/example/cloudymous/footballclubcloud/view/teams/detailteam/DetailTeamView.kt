package com.example.cloudymous.footballclubcloud.view.teams.detailteam

import com.example.cloudymous.footballclubcloud.model.Team

interface DetailTeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}