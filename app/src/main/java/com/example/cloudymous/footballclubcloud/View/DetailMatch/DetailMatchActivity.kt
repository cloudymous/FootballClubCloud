package com.example.cloudymous.footballclubcloud.View.DetailMatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.Model.LastMatch
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val event = intent.getSerializableExtra("event") as LastMatch

        date.text = event.eventDate
        home_team.text = event.homeTeam
        away_team.text = event.awayTeam
        home_score.text = event.homeScore
        away_score.text = event.awayScore

    }

}
