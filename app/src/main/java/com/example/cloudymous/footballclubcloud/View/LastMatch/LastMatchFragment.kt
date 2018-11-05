package com.example.cloudymous.footballclubcloud.View.LastMatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.LastMatch
import com.example.cloudymous.footballclubcloud.Presenter.LastMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.invisible
import com.example.cloudymous.footballclubcloud.Utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.jetbrains.anko.support.v4.onRefresh

class LastMatchFragment : Fragment(), LastMatchView {

    private var lastmatch: MutableList<LastMatch> = mutableListOf()

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

        adapter = LastMatchAdapter(context, lastmatch)
        last_match_list.layoutManager = LinearLayoutManager(context)
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

    override fun showLastMatchList(data: List<LastMatch>) {
        swipe_refresh.isRefreshing = false
        lastmatch.clear()
        lastmatch.addAll(data)
        adapter.notifyDataSetChanged()
    }


}
