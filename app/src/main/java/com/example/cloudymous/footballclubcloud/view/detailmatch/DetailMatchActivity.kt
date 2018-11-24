package com.example.cloudymous.footballclubcloud.view.detailmatch

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.R.id.add_to_favorite
import com.example.cloudymous.footballclubcloud.R.menu.detail_menu
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.db.databaseFavorite
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.model.FavoriteMatch
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.presenter.DetailMatchPresenter
import com.example.cloudymous.footballclubcloud.utils.formatDate
import com.example.cloudymous.footballclubcloud.utils.formatTime
import com.example.cloudymous.footballclubcloud.utils.invisible
import com.example.cloudymous.footballclubcloud.utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast
import java.sql.SQLClientInfoException

class DetailMatchActivity : AppCompatActivity(), DetailMatchView {

    private lateinit var presenter: DetailMatchPresenter
    private lateinit var event: DetailMatch

    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var id: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        id = intent.getStringExtra("eventId")

        favState()

        val request = ApiRepository()
        val gson = Gson()



        presenter = DetailMatchPresenter(this, request, gson)
        presenter.getDetailMatch(id)

    }

    private fun favState() {
        databaseFavorite.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
                .whereArgs("(EVENT_ID = {id})", "id" to id)

            val favorite = result.parseList(classParser<FavoriteMatch>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun showLoading() {
        progress_bar.visible()
    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
        setFav()
        menuItem = menu
        return true
    }

    override fun showTeam(data: List<DetailMatch>) {

        event = DetailMatch(
            data[0].eventId,
            data[0].eventDate,
            data[0].eventTime,
            data[0].homeTeamId,
            data[0].homeTeam,
            data[0].awayTeamId,
            data[0].awayTeam,
            data[0].homeScore,
            data[0].awayScore
        )

        presenter.getTeamBadge(data[0].homeTeamId, data[0].awayTeamId)

        date.text = formatDate(data[0].eventDate)
        time.text = formatTime(data[0].eventTime)
        team_home.text = data[0].homeTeam
        team_away.text = data[0].awayTeam
        home_score_detail.text = data[0].homeScore
        away_score_detail.text = data[0].awayScore
        home_redcards.text = data[0].homeRedCards?.replace(";", "\n")
        away_redcards.text = data[0].awayRedCards?.replace(";", "\n")
        home_yellowcards.text = data[0].homeYellowCards?.replace(";", "\n")
        away_yellowcards.text = data[0].awayYellowCards?.replace(";", "\n")
        home_goalkeepers.text = data[0].homeGoalKeeper?.replace(";", "\n")
        away_goalkeepers.text = data[0].awayGoalKeeper?.replace(";", "\n")
        home_linedef.text = data[0].homeLineDefense?.replace(";", "\n")
        away_linedef.text = data[0].awayLineDefense?.replace(";", "\n")
        home_linemid.text = data[0].homeLineMidfield?.replace(";", "\n")
        away_linemid.text = data[0].awayLineMidfield?.replace(";", "\n")
        home_lineforward.text = data[0].homeLineForward?.replace(";", "\n")
        away_lineforward.text = data[0].awayLineForward?.replace(";", "\n")
        home_linesubs.text = data[0].homeSubtitutes?.replace(";", "\n")
        away_linesubs.text = data[0].awaySubtitutes?.replace(";", "\n")

    }

    override fun showBadge(dataHome: List<Team>, dataAway: List<Team>) {
        Picasso.get().load(dataHome[0].teamBadge).into(home_badge)
        Picasso.get().load(dataAway[0].teamBadge).into(away_badge)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            add_to_favorite -> {

                if (isFavorite) removeFromFav() else addToFavorite()

                isFavorite = !isFavorite
                setFav()

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite() {
        try {
            databaseFavorite.use {
                insert(
                    FavoriteMatch.TABLE_FAVORITE_MATCH,
                    FavoriteMatch.EVENT_ID to event.eventId,
                    FavoriteMatch.EVENT_DATE to event.eventDate,
                    FavoriteMatch.EVENT_TIME to event.eventTime,
                    FavoriteMatch.EVENT_HOMETEAM to event.homeTeam,
                    FavoriteMatch.EVENT_HOMESCORE to event.homeScore,
                    FavoriteMatch.EVENT_AWAYTEAM to event.awayTeam,
                    FavoriteMatch.EVENT_AWAYSCORE to event.awayScore
                )
            }
            toast("Add to favorite")
        } catch (e: SQLClientInfoException) {
            toast(e.localizedMessage)
        }
    }

    private fun removeFromFav() {
        try {
            databaseFavorite.use {
                delete(FavoriteMatch.TABLE_FAVORITE_MATCH, "EVENT_ID = {id}", "id" to id)
            }
            toast("Remove from favorite")
        } catch (e: SQLClientInfoException) {
            toast(e.localizedMessage)
        }
    }

    private fun setFav() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }
}
