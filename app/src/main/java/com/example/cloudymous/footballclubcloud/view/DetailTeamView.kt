package com.example.cloudymous.footballclubcloud.view

import com.example.cloudymous.footballclubcloud.model.Team

interface DetailTeamView {
    fun showTeamDetail(data: List<Team>)
}