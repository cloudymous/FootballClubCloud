package com.example.cloudymous.footballclubcloud.View


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter = MainPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)

    }
}
