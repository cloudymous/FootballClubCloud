package com.example.cloudymous.footballclubcloud.view.favorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.example.cloudymous.footballclubcloud.model.FavoriteMatch
import com.example.cloudymous.footballclubcloud.view.detailmatch.DetailMatchActivity
import kotlinx.android.synthetic.main.fragment_favorite_match.*
import org.jetbrains.anko.startActivity

class FavoriteFragment : Fragment() {

    private var favoritesMatch: MutableList<FavoriteMatch> = mutableListOf()

    private lateinit var adapter: FavoriteMatchAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteMatchAdapter(requireContext(), favoritesMatch) {
            requireContext().startActivity<DetailMatchActivity>("event" to it)
        }

        favorite_match_list.layoutManager = LinearLayoutManager(context)
        favorite_match_list.adapter = adapter
    }

}