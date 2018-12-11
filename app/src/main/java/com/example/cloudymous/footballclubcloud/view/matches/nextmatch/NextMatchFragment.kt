package com.example.cloudymous.footballclubcloud.view.matches.nextmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.presenter.NextMatchPresenter
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.example.cloudymous.footballclubcloud.view.matches.detail.DetailMatchActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match_next.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class NextMatchFragment : Fragment(), NextMatchView {

    private var nextmatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: NextMatchAdapter
    private lateinit var presenter: NextMatchPresenter
    private lateinit var leagueName: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = NextMatchAdapter(
            requireContext(),
            nextmatch
        ) {
            requireContext().startActivity<DetailMatchActivity>("eventId" to "${it.eventId}")
        }

        next_match_list.layoutManager = LinearLayoutManager(context)
        next_match_list.adapter = adapter

        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems)

        league_spinner_next.adapter = spinnerAdapter

        val request = ApiRepository()
        val gson = Gson()

        league_spinner_next.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueName = league_spinner_next.selectedItem.toString()
                when (leagueName) {
                    "English Premier League" -> presenter.getNextMatch("4328")
                    "German Bundesliga" -> presenter.getNextMatch("4331")
                    "Italian Serie A" -> presenter.getNextMatch("4332")
                    "French Ligue 1" -> presenter.getNextMatch("4334")
                    "Spanish La Liga" -> presenter.getNextMatch("4335")
                    "Netherlands Eredivisie" -> presenter.getNextMatch("4337")

                    else -> presenter.getNextMatch(leagueName)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        presenter = NextMatchPresenter(this, request, gson)

        swipe_refresh.onRefresh {
            presenter.getNextMatch(leagueName)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_match_next, container, false)
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