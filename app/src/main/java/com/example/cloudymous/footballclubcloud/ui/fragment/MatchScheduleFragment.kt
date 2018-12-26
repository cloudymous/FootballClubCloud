package com.example.cloudymous.footballclubcloud.ui.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.*
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.adapter.MatchAdapter
import com.example.cloudymous.footballclubcloud.adapter.pager.MatchSchedulePagerAdapter
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.presenter.MatchPresenter
import com.example.cloudymous.footballclubcloud.ui.view.MatchView
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.google.gson.Gson
import org.jetbrains.anko.find

class MatchScheduleFragment : Fragment(), MatchView {

    private var searchMatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var queryTextListener: SearchView.OnQueryTextListener
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MatchAdapter
    private lateinit var presenter: MatchPresenter
    private lateinit var pager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val request = ApiRepository()
        val gson = Gson()
        presenter = MatchPresenter(this, request, gson)
        recyclerView.invisible()
        pager.visible()
        tabs.visible()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val viewRoot = inflater.inflate(R.layout.fragment_match, container, false)
        pager = viewRoot.find(R.id.matches_pager_main)
        tabs = viewRoot.find(R.id.tabs_main)
        recyclerView = viewRoot.find(R.id.search_result_rc)

        val adapter = MatchSchedulePagerAdapter(childFragmentManager)
        adapter.addFragment(LastMatchFragment(), "Last Match")
        adapter.addFragment(NextMatchFragment(), "Next Match")
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        return viewRoot
    }


    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMatchList(data: List<DetailMatch>) {
        recyclerView.visible()
        pager.invisible()
        tabs.invisible()

        searchMatch.clear()
        searchMatch.addAll(data)
        adapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.search_menu, menu)
        val searchView = menu?.findItem(R.id.search_action)?.actionView as SearchView?
        searchView?.queryHint = "Search Matches"

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                presenter.getSearchResult(query)
                return false
            }
        })

    }

}
