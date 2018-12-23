package com.example.cloudymous.footballclubcloud.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.adapter.LastMatchAdapter
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.presenter.MatchPresenter
import com.example.cloudymous.footballclubcloud.ui.activity.DetailMatchActivity
import com.example.cloudymous.footballclubcloud.ui.view.MatchView
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match_last.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class LastMatchFragment : Fragment(), MatchView {

    private var lastmatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: LastMatchAdapter
    private lateinit var presenter: MatchPresenter
    private lateinit var leagueName: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = LastMatchAdapter(
            requireContext(),
            lastmatch
        ) {
            requireContext().startActivity<DetailMatchActivity>("eventId" to "${it.eventId}")
        }

        last_match_list.layoutManager = LinearLayoutManager(context)
        last_match_list.adapter = adapter

        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems)

        league_spinner.adapter = spinnerAdapter

        val request = ApiRepository()
        val gson = Gson()

        league_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueName = league_spinner.selectedItem.toString()
                when (leagueName) {
                    "English Premier League" -> leagueName = "4328"
                    "German Bundesliga" -> leagueName = "4331"
                    "Italian Serie A" -> leagueName = "4332"
                    "French Ligue 1" -> leagueName = "4334"
                    "Spanish La Liga" -> leagueName = "4335"
                    "Netherlands Eredivisie" -> leagueName = "4337"
                }
                presenter.getLastMatch(leagueName)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        presenter = MatchPresenter(this, request, gson)

        swipe_refresh.onRefresh {
            presenter.getLastMatch(leagueName)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_match_last, container, false)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showMatchList(data: List<DetailMatch>) {
        swipe_refresh.isRefreshing
        lastmatch.clear()
        lastmatch.addAll(data)
        adapter.notifyDataSetChanged()
    }

}