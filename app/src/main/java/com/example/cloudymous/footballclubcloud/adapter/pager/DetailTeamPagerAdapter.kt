package com.example.cloudymous.footballclubcloud.adapter.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.cloudymous.footballclubcloud.ui.fragment.DetailTeamOverviewFragment
import com.example.cloudymous.footballclubcloud.ui.fragment.TeamPlayerFragment

class DetailTeamPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        DetailTeamOverviewFragment(),
        TeamPlayerFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Overview"
            else -> "Players"
        }
    }
}