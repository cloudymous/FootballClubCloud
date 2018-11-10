package com.example.cloudymous.footballclubcloud.View.DetailMatch

interface DetailMatchView {

    fun showLoading()
    fun hideLoading()
    fun showDetailMatch(data: List<DetailMatch>)
}