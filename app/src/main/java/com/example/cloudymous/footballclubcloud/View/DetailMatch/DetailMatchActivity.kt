package com.example.cloudymous.footballclubcloud.View.DetailMatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.Presenter.DetailMatchPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.invisible
import com.example.cloudymous.footballclubcloud.Utils.visible
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
        presenter.getMatchDetail("eventId")
        Log.v("eventId Value is:", eventId)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showDetailMatch(data: DetailMatch) {
        date.text = data.eventDate
        home_team.text = data.homeTeam
        away_team.text = data.awayTeam
        home_score.text = data.homeScore
        away_score.text = data.awayScore
    }

}
