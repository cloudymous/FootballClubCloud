package com.example.cloudymous.footballclubcloud.view.lastmatch

import com.example.cloudymous.footballclubcloud.model.DetailMatch

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<DetailMatch>)
}