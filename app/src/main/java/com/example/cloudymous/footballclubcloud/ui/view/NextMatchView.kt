package com.example.cloudymous.footballclubcloud.ui.view

import com.example.cloudymous.footballclubcloud.model.DetailMatch

interface NextMatchView {

    fun showLoading()
    fun hideLoading()
    fun showNextMatch(data: List<DetailMatch>)
}