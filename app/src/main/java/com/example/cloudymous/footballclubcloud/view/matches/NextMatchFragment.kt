package com.example.cloudymous.footballclubcloud.view.matches

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.presenter.NextMatchPresenter
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.example.cloudymous.footballclubcloud.view.details.DetailMatchActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_teams.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class NextMatchFragment : Fragment(), NextMatchView {

    private var nextmatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: NextMatchAdapter
    private lateinit var presenter: NextMatchPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = NextMatchAdapter(requireContext(), nextmatch) {
            requireContext().startActivity<DetailMatchActivity>("eventId" to "${it.eventId}")
        }

        next_match_list.layoutManager = LinearLayoutManager(context)
        next_match_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()

        val leagueId = resources.getString(R.string.leagueId)
        presenter = NextMatchPresenter(this, request, gson)
        presenter.getNextMatch(leagueId)

        swipe_refresh.onRefresh {
            presenter.getNextMatch(leagueId)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showNextMatchList(data: List<DetailMatch>) {
        swipe_refresh.isRefreshing = false
        nextmatch.clear()
        nextmatch.addAll(data)
        adapter.notifyDataSetChanged()
    }


}