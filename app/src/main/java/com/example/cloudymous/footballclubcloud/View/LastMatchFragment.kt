package com.example.cloudymous.footballclubcloud.View


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.LastMatchEvent
import com.example.cloudymous.footballclubcloud.Presenter.LastMatchAdapter
import com.example.cloudymous.footballclubcloud.Presenter.LastMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.invisible
import com.example.cloudymous.footballclubcloud.Utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.jetbrains.anko.support.v4.onRefresh

class LastMatchFragment : Fragment(), LastMatchView {

    private var lastmatchevent: MutableList<LastMatchEvent> = mutableListOf()

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

        adapter = LastMatchAdapter(lastmatchevent)
        last_match_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()

        presenter = LastMatchPresenter(this, request, gson)
        presenter.getLastMatch("4328")

        swipe_refresh.onRefresh {
            presenter.getLastMatch("4328")
        }


    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showLastMatch(data: List<LastMatchEvent>) {
        swipe_refresh.isRefreshing = false
        lastmatchevent.clear()
        lastmatchevent.addAll(data)
        adapter.notifyDataSetChanged()
    }


}
