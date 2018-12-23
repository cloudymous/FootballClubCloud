package com.example.cloudymous.footballclubcloud.adapter.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.cloudymous.footballclubcloud.ui.fragment.LastMatchFragment
import com.example.cloudymous.footballclubcloud.ui.fragment.NextMatchFragment
import com.example.cloudymous.footballclubcloud.ui.fragment.TeamsFragment

class MatchSchedulePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        LastMatchFragment(),
        NextMatchFragment(),
        TeamsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Last Match"
            else -> "Next Match"
        }
    }
}