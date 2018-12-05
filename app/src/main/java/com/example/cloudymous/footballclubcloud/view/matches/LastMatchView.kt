package com.example.cloudymous.footballclubcloud.view.matches

import com.example.cloudymous.footballclubcloud.model.DetailMatch

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLastMatchList(data: List<DetailMatch>)
}