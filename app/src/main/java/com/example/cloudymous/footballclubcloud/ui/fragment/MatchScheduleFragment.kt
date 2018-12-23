package com.example.cloudymous.footballclubcloud.ui.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.pager.MatchSchedulePagerAdapter

class MatchScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_match_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pager = view.findViewById<ViewPager>(R.id.matches_pager_main)
        val tabs = view.findViewById<TabLayout>(R.id.tabs_main)

//        setHasOptionsMenu(true)

        pager.adapter = MatchSchedulePagerAdapter(
            childFragmentManager
        )
        tabs.setupWithViewPager(pager)
    }
}