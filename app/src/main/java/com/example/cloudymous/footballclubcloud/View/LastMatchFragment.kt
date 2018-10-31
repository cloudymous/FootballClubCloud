package com.example.cloudymous.footballclubcloud.View


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.LastMatch
import com.example.cloudymous.footballclubcloud.Presenter.LastMatchAdapter
import com.example.cloudymous.footballclubcloud.Presenter.LastMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.invisible
import com.example.cloudymous.footballclubcloud.Utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_last_match.*

class LastMatchFragment : Fragment(), LastMatchView {

    private var lastmatch: MutableList<LastMatch> = mutableListOf()

    private lateinit var adapter: LastMatchAdapter
    private lateinit var presenter: LastMatchPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_last_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LastMatchAdapter(lastmatch)
        last_match_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()

        val leagueId = R.string.leagueId.toString()
        presenter = LastMatchPresenter(this, request, gson)
        presenter.getLastMatch(leagueId)

    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showLastMatchList(data: List<LastMatch>) {
        swipeRefresh.isRefreshing = false
        lastmatch.clear()
        lastmatch.addAll(data)
        adapter.notifyDataSetChanged()

    }


}
