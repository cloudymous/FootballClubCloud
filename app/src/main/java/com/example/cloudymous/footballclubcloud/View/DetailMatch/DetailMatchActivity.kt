package com.example.cloudymous.footballclubcloud.View.DetailMatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.Presenter.DetailMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : AppCompatActivity(), DetailMatchView {

    private lateinit var presenter: DetailMatchPresenter
    private lateinit var eventId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val intent = intent
        eventId = intent.getStringExtra("eventID")

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailMatchPresenter(this, request, gson)
        presenter.getMatchDetail("")

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun showDetailMatch(data: DetailMatch) {
        date.text = data.eventDate
        home_team.text = data.homeTeam
        away_team.text = data.awayTeam
        home_score.text = data.homeScore
        away_score.text = data.awayScore
    }

}
