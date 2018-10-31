package com.example.cloudymous.footballclubcloud.View

import com.example.cloudymous.footballclubcloud.Model.LastMatch

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<LastMatch>)
}