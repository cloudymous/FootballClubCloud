package com.example.cloudymous.footballclubcloud.view.favorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.db.databaseFavorite
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.example.cloudymous.footballclubcloud.view.detailmatch.DetailMatchActivity
import kotlinx.android.synthetic.main.fragment_favorite_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class FavoriteFragment : Fragment(), FavoriteView {

    private var favoritesMatch: MutableList<DetailMatch> = mutableListOf()

    private lateinit var adapter: FavoriteMatchAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteMatchAdapter(requireContext(), favoritesMatch) {
            requireContext().startActivity<DetailMatchActivity>("event" to it)
        }

        favorite_match_list.layoutManager = LinearLayoutManager(context)
        favorite_match_list.adapter = adapter

        swipe_refresh.onRefresh {
            showFavorites()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_match, container, false)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun onResume() {
        super.onResume()
        showFavorites()
    }

    private fun showFavorites() {
        favoritesMatch.clear()
        context?.databaseFavorite?.use {
            swipe_refresh.isRefreshing = false
            val result = select(DetailMatch.TABLE_FAVORITE_MATCH)
            val favorites = result.parseList(classParser<DetailMatch>())
            favoritesMatch.addAll(favorites)
            adapter.notifyDataSetChanged()
        }
    }

}