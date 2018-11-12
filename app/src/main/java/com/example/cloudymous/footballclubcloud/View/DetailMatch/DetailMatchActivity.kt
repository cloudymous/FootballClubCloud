package com.example.cloudymous.footballclubcloud.View.DetailMatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val event = intent.getSerializableExtra("event") as DetailMatch

        date.text = event.eventDate

        team_home.text = event.homeTeam
        team_away.text = event.awayTeam

        home_score.text = event.homeScore
        away_score.text = event.awayScore

        home_redcards.text = event.homeRedCards
        away_redcards.text = event.awayRedCards

        home_yellowcards.text = event.homeYellowCards
        away_yellowcards.text = event.awayYellowCards

        home_goalkeepers.text = event.homeGoalKeeper
        away_goalkeepers.text = event.awayGoalKeeper

        home_linedef.text = event.homeLineDefense
        away_linedef.text = event.awayLineDefense

        home_linemid.text = event.homeLineMidfield
        away_linemid.text = event.awayLineMidfield

        home_lineforward.text = event.homeLineForward
        away_lineforward.text = event.awayLineForward

        home_linesubs.text = event.homeSubtitutes
        away_linesubs.text = event.awaySubtitutes

    }

}
