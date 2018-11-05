package com.example.cloudymous.footballclubcloud.View.LastMatch

import com.example.cloudymous.footballclubcloud.Model.LastMatch
import com.example.cloudymous.footballclubcloud.Model.Team

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<LastMatch>)
}