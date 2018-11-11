package com.example.cloudymous.footballclubcloud.View.NextMatch

import com.example.cloudymous.footballclubcloud.Model.DetailMatch

interface NextMatchView {

    fun showLoading()
    fun hideLoading()
    fun showNextMatchList(data: List<DetailMatch>)
}