package com.example.cloudymous.footballclubcloud.View

import com.example.cloudymous.footballclubcloud.Model.LastMatchEvent

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatch(data: List<LastMatchEvent>)
}