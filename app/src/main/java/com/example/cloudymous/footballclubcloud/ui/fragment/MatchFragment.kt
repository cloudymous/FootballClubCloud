package com.example.cloudymous.footballclubcloud.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.adapter.MatchAdapter
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.presenter.MatchPresenter
import com.example.cloudymous.footballclubcloud.ui.activity.DetailMatchActivity
import com.example.cloudymous.footballclubcloud.ui.view.MatchView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match.*
import org.jetbrains.anko.startActivity

class MatchFragment : Fragment(), MatchView {

    private var match: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: MatchAdapter
    private lateinit var presenter: MatchPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = MatchAdapter(
            requireContext(),
            match
        ) {
            requireContext().startActivity<DetailMatchActivity>("eventId" to "${it.eventId}")
        }

        match_list.layoutManager = LinearLayoutManager(context)
        match_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()

        presenter = MatchPresenter(this, request, gson)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMatchList(data: List<DetailMatch>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}