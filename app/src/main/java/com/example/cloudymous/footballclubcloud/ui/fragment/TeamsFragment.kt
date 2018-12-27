package com.example.cloudymous.footballclubcloud.ui.fragment

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.adapter.TeamsAdapter
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.presenter.TeamsPresenter
import com.example.cloudymous.footballclubcloud.ui.activity.DetailTeamActivity
import com.example.cloudymous.footballclubcloud.ui.view.TeamView
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_team.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class TeamsFragment : Fragment(), TeamView {

    private var teams: MutableList<Team> = mutableListOf()
    private var searchResult: MutableList<Team> = mutableListOf()
    private var searchView: SearchView? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var queryTextListener: SearchView.OnQueryTextListener
    private lateinit var presenter: TeamsPresenter
    private lateinit var adapter: TeamsAdapter
    private lateinit var leagueName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = TeamsAdapter(requireContext(), teams) {
            requireContext().startActivity<DetailTeamActivity>("teamId" to "${it.teamId}")
        }

//        recyclerView.invisible()

        team_list.layoutManager = LinearLayoutManager(context)
        search_result.layoutManager = LinearLayoutManager(context)
        team_list.adapter = adapter

        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        league_spinner_team.adapter = spinnerAdapter

        val request = ApiRepository()
        val gson = Gson()

        league_spinner_team.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                leagueName = league_spinner_team.selectedItem.toString()
                presenter.getTeams(leagueName)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        presenter = TeamsPresenter(this, request, gson)

        swipe_refresh.onRefresh {
            presenter.getTeams(leagueName)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_team, container, false)
        recyclerView = rootView.find(R.id.search_result)

        return rootView
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showTeamList(data: List<Team>) {
        swipe_refresh.isRefreshing = false
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun showSearchTeam(data: List<Team>) {
        search_result.visible()

        searchResult.clear()
        searchResult.addAll(data)
        adapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search_action)
        val searchManager: SearchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        if (searchView != null) {
            searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
            queryTextListener = object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    var querySearch = query
                    querySearch.toLowerCase()
                    querySearch = querySearch.replace(" ", "_")
                    adapter = TeamsAdapter(
                        requireContext(),
                        teams
                    ) {
                        requireContext().startActivity<DetailTeamActivity>("teamId" to "${it.teamId}")
                    }
                    search_result.adapter = adapter
                    presenter.searchTeams(querySearch)
                    return true
                }
            }
            searchView?.setOnQueryTextListener(queryTextListener)
        }
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(menuItem: MenuItem): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(menuItem: MenuItem): Boolean {
                search_result.invisible()
                team_list.visible()
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