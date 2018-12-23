package com.example.cloudymous.footballclubcloud.adapter.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MatchSchedulePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val fragmentPages = ArrayList<Fragment>()
    val fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentPages[position]
    }

    override fun getCount(): Int {
        return fragmentPages.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentPages.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}