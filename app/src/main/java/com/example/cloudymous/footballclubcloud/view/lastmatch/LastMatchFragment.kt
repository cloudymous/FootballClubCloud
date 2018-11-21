package com.example.cloudymous.footballclubcloud.view.lastmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.cloudymous.footballclubcloud.model.DetailMatch

class LastMatchFragment : Fragment() {

    private var lastmatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: LastMatchAdapter
    private lateinit var presenter: LastMatchPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}