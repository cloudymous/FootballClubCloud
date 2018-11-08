package com.example.cloudymous.footballclubcloud.View.NextMatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.NextMatch
import com.example.cloudymous.footballclubcloud.Presenter.NextMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.invisible
import com.example.cloudymous.footballclubcloud.Utils.visible
import com.example.cloudymous.footballclubcloud.View.DetailMatch.DetailMatch
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class NextMatchFragment : Fragment(), NextMatchView {

    private val nextmatch: MutableList<NextMatch> = mutableListOf()

    private lateinit var adapter: NextMatchAdapter
    private lateinit var presenter: NextMatchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NextMatchAdapter(requireContext(), nextmatch) {
            requireContext().startActivity<DetailMatch>("event" to "${it}")
        }

        next_match_list.layoutManager = LinearLayoutManager(context)
        next_match_list.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()

        presenter = NextMatchPresenter(this, request, gson)
        presenter.getNextMatch("4328")


        swipe_refresh.onRefresh {
            presenter.getNextMatch("4328")
        }
    }

    override fun showLoading() {
        progress_bar.visible()

    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showNextMatchList(data: List<NextMatch>) {
        swipe_refresh.isRefreshing = false
        nextmatch.clear()
        nextmatch.addAll(data)
        adapter.notifyDataSetChanged()
    }

}
