package com.example.cloudymous.footballclubcloud.view.pageradapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.cloudymous.footballclubcloud.view.matches.nextmatch.NextMatchFragment
import com.example.cloudymous.footballclubcloud.view.teams.detailteam.DetailTeamOverviewFragment

class DetailTeamPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        DetailTeamOverviewFragment(),
        NextMatchFragment()
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