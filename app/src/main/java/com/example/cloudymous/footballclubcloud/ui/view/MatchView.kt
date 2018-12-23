package com.example.cloudymous.footballclubcloud.ui.view

import com.example.cloudymous.footballclubcloud.model.DetailMatch

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<DetailMatch>)
}