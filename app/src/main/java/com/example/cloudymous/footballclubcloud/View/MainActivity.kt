package com.example.cloudymous.footballclubcloud.View


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudymous.footballclubcloud.Presenter.MatchPagerAdapter
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        viewpager_main.adapter = MatchPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)


    }
}
