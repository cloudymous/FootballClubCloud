package com.example.cloudymous.footballclubcloud.ui.fragment

import android.app.SearchManager
import android.content.Context
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
import com.example.cloudymous.footballclubcloud.ui.activity.DetailMatchActivity
import com.example.cloudymous.footballclubcloud.ui.view.MatchView
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MatchScheduleFragment : Fragment(), MatchView {

    private var searchMatch: MutableList<DetailMatch> = mutableListOf()
    private var searchView: SearchView? = null

    private lateinit var queryTextListener: SearchView.OnQueryTextListener
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
        search_result_rc.invisible()
        pager.visible()
        tabs.visible()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val viewRoot = inflater.inflate(R.layout.fragment_match_schedule, container, false)
        pager = viewRoot.find(R.id.matches_pager_main)
        tabs = viewRoot.find(R.id.tabs_main)

        val adapter = MatchSchedulePagerAdapter(childFragmentManager)
        adapter.addFragment(LastMatchFragment(), "Last Match")
        adapter.addFragment(NextMatchFragment(), "Next Match")
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        search_result_rc.layoutManager = LinearLayoutManager(activity)

        return viewRoot
    }


    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMatchList(data: List<DetailMatch>) {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search_action)
        val searchManager: SearchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        if (searchItem !== null) {
            searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
            queryTextListener = object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    var querySearch = query
                    querySearch.toLowerCase()
                    querySearch = querySearch.replace(" ", "_")
                    adapter = MatchAdapter(requireContext(), searchMatch) {
                        requireContext().startActivity<DetailMatchActivity>("eventId" to "${it.eventId}")
                    }
                    search_result_rc.adapter = adapter
                    presenter.getSearchResult(querySearch)
                    return true
                }
            }
            searchView?.setOnQueryTextListener(queryTextListener)
        }

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(menuItem: MenuItem): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                search_result_rc.invisible()
                pager.visible()
                tabs.visible()
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_action -> {
                return false
            }
        }
        searchView?.setOnQueryTextListener(queryTextListener)
        return super.onOptionsItemSelected(item)
    }

}
