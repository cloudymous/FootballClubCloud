package com.example.cloudymous.footballclubcloud.view.favorites.teamsfavorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.db.FavoriteTeam
import com.example.cloudymous.footballclubcloud.db.databaseFavoriteTeam
import kotlinx.android.synthetic.main.fragment_team_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast

class FavoriteTeamFragment : Fragment() {

    private var favoritesTeam: MutableList<FavoriteTeam> = mutableListOf()

    private lateinit var adapter: FavoriteTeamAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteTeamAdapter(
            requireContext(),
            favoritesTeam
        ) {
            toast("Hello").show()
        }

        team_list.layoutManager = LinearLayoutManager(context)
        team_list.adapter = adapter

        swipe_refresh.onRefresh {
            showFavorites()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_team_favorite, container, false)
    }

    override fun onResume() {
        super.onResume()
        showFavorites()
    }

    private fun showFavorites() {
        favoritesTeam.clear()
        context?.databaseFavoriteTeam?.use {
            swipe_refresh.isRefreshing = false
            val result = select(FavoriteTeam.TABLE_FAVORITE)
            val favorites = result.parseList(classParser<FavoriteTeam>())
            favoritesTeam.addAll(favorites)
            adapter.notifyDataSetChanged()
        }
    }
}