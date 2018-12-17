package com.example.cloudymous.footballclubcloud.view.pageradapter

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pager = view.findViewById<ViewPager>(R.id.team_pager_main)
        val tabs = view.findViewById<TabLayout>(R.id.tabs_main)

//        setHasOptionsMenu(true)

        pager.adapter = FavoritesPagerAdapter(
            childFragmentManager
        )

        tabs.setupWithViewPager(pager)
    }
}
