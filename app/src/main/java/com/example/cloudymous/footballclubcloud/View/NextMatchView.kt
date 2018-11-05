package com.example.cloudymous.footballclubcloud.View

import com.example.cloudymous.footballclubcloud.Model.NextMatch

interface NextMatchView {

    fun showLoading()
    fun hideLoading()
    fun showNextMatchList(data: List<NextMatch>)
}