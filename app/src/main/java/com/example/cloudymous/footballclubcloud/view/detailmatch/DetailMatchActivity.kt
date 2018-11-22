package com.example.cloudymous.footballclubcloud.view.detailmatch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.R.id.add_to_favorite
import com.example.cloudymous.footballclubcloud.R.menu.detail_menu
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.db.databaseFavorite
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.model.GetTeamPresenter
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.utils.formatDate
import com.example.cloudymous.footballclubcloud.utils.formatTime
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast
import java.sql.SQLClientInfoException

class DetailMatchActivity : AppCompatActivity(), DetailMatchView {

    private lateinit var presenter: GetTeamPresenter
    private lateinit var event: DetailMatch


    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false


//    private lateinit var intent: Intent
//    private var event = intent.getSerializableExtra("event") as DetailMatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        event = intent.getSerializableExtra("event") as DetailMatch

        val request = ApiRepository()
        val gson = Gson()

        presenter = GetTeamPresenter(this, request, gson)
        presenter.getTeamDetail(event.homeTeamId, event.awayTeamId)

        date.text = formatDate(event.eventDate)
        time.text = formatTime(event.eventTime)
        team_home.text = event.homeTeam
        team_away.text = event.awayTeam
        home_score_detail.text = event.homeScore
        away_score_detail.text = event.awayScore
        home_redcards.text = event.homeRedCards?.replace(";", "\n")
        away_redcards.text = event.awayRedCards?.replace(";", "\n")
        home_yellowcards.text = event.homeYellowCards?.replace(";", "\n")
        away_yellowcards.text = event.awayYellowCards?.replace(";", "\n")
        home_goalkeepers.text = event.homeGoalKeeper?.replace(";", "\n")
        away_goalkeepers.text = event.awayGoalKeeper?.replace(";", "\n")
        home_linedef.text = event.homeLineDefense?.replace(";", "\n")
        away_linedef.text = event.awayLineDefense?.replace(";", "\n")
        home_linemid.text = event.homeLineMidfield?.replace(";", "\n")
        away_linemid.text = event.awayLineMidfield?.replace(";", "\n")
        home_lineforward.text = event.homeLineForward?.replace(";", "\n")
        away_lineforward.text = event.awayLineForward?.replace(";", "\n")
        home_linesubs.text = event.homeSubtitutes?.replace(";", "\n")
        away_linesubs.text = event.awaySubtitutes?.replace(";", "\n")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            add_to_favorite -> {
                addToFavorite()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite() {
        try {
            databaseFavorite.use {
                insert(
                    DetailMatch.TABLE_FAVORITE_MATCH,
                    DetailMatch.EVENT_ID to event.eventId,
                    DetailMatch.EVENT_DATE to event.eventDate,
                    DetailMatch.EVENT_TIME to event.eventTime,
                    DetailMatch.EVENT_HOME_TEAM to event.homeTeam,
                    DetailMatch.EVENT_HOME_SCORE to event.homeScore,
                    DetailMatch.EVENT_AWAY_TEAM to event.awayTeam,
                    DetailMatch.EVENT_AWAY_SCORE to event.awayScore
                )
            }
            toast("Add to favorite")
        } catch (e: SQLClientInfoException) {
            toast(e.localizedMessage)
        }
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showTeam(dataHome: List<Team>, dataAway: List<Team>) {

        event = DetailMatch(
            event.eventId,
            event.eventDate,
            event.eventTime,
            event.homeTeamId,
            event.homeTeam,
            event.awayTeamId,
            event.awayTeam,
            event.homeScore,
            event.awayScore,
            event.homeRedCards,
            event.awayRedCards,
            event.homeYellowCards,
            event.awayYellowCards,
            event.homeGoalKeeper,
            event.awayGoalKeeper,
            event.homeLineDefense,
            event.awayLineDefense,
            event.homeLineMidfield,
            event.awayLineMidfield,
            event.homeLineForward,
            event.awayLineForward,
            event.homeSubtitutes,
            event.awaySubtitutes
        )

        Picasso.get().load(dataHome[0].teamBadge).into(home_badge)
        Picasso.get().load(dataAway[0].teamBadge).into(away_badge)
    }
}