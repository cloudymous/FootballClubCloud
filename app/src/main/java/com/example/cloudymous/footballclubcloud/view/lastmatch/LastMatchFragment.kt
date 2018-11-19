package com.example.cloudymous.footballclubcloud.view.lastmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.presenter.LastMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.example.cloudymous.footballclubcloud.view.detailmatch.DetailMatchActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class LastMatchFragment : Fragment(), LastMatchView {

    private var lastmatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: LastMatchAdapter
    private lateinit var presenter: LastMatchPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_last_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LastMatchAdapter(requireContext(), lastmatch) {
            requireContext().startActivity<DetailMatchActivity>("event" to it)
        }
        last_match_list.layoutManager = LinearLayoutManager(context)
        last_match_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()

        val leagueId = resources.getString(R.string.leagueId)

        presenter = LastMatchPresenter(this, request, gson)
        presenter.getLastMatch(leagueId)

        swipe_refresh.onRefresh {
            presenter.getLastMatch(leagueId)
        }

    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showLastMatchList(data: List<DetailMatch>) {
        swipe_refresh.isRefreshing = false
        lastmatch.clear()
        lastmatch.addAll(data)
        adapter.notifyDataSetChanged()
    }


}
