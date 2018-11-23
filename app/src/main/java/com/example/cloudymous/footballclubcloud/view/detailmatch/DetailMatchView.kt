package com.example.cloudymous.footballclubcloud.view.detailmatch

import com.example.cloudymous.footballclubcloud.model.DetailMatch

interface DetailMatchView {

    fun showLoading()
    fun hideLoading()
    fun showTeam(data: List<DetailMatch>)
}