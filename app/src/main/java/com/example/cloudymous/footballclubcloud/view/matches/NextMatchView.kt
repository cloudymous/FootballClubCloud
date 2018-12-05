package com.example.cloudymous.footballclubcloud.view.matches

import com.example.cloudymous.footballclubcloud.model.DetailMatch

interface NextMatchView {

    fun showLoading()
    fun hideLoading()
    fun showNextMatchList(data: List<DetailMatch>)
}