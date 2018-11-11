package com.example.cloudymous.footballclubcloud.View.LastMatch

import com.example.cloudymous.footballclubcloud.Model.DetailMatch

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<DetailMatch>)
}