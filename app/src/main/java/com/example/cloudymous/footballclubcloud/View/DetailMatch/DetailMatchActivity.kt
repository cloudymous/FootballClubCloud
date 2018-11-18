package com.example.cloudymous.footballclubcloud.View.DetailMatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.Model.Team
import com.example.cloudymous.footballclubcloud.Presenter.GetTeamPresenter
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.invisible
import com.example.cloudymous.footballclubcloud.Utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import java.text.SimpleDateFormat

class DetailMatchActivity : AppCompatActivity(), DetailMatchView{

    private lateinit var presenter : GetTeamPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val event = intent.getSerializableExtra("event") as DetailMatch

        val request = ApiRepository()
        val gson = Gson()

        presenter = GetTeamPresenter(this, request, gson)

        presenter.getTeamDetail(event.homeTeamId, event.awayTeamId)

        date.text = formatDate(event.eventDate)

        team_home.text = event.homeTeam
        team_away.text = event.awayTeam

        home_score_detail.text = event.homeScore
        away_score_detail.text = event.awayScore

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

    private fun formatDate(strDate: String?) : String {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        val date = simpleDateFormat.parse(strDate)
        val dateWithDay = SimpleDateFormat("EEEE, dd MMM yyy")
        return  dateWithDay.format(date)
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showTeam(dataHome: List<Team>, dataAway: List<Team>) {
        Picasso.get().load(dataHome[0].teamBadge).into(home_badge)
        Picasso.get().load(dataAway[0].teamBadge).into(away_badge)
        Log.v("teamBadgeHome", dataHome[0].teamBadge)
        Log.v("awayBadgeHome", dataAway[0].teamBadge)
    }

}
