package com.example.cloudymous.footballclubcloud.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.cloudymous.footballclubcloud.view.lastmatch.LastMatchFragment
import com.example.cloudymous.footballclubcloud.view.nextmatch.NextMatchFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        LastMatchFragment(),
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
            0 -> "Last Match"
            else -> "Next Match"
        }
    }
}