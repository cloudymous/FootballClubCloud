package com.example.cloudymous.footballclubcloud.view.teams.detailteam

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.R.id.add_to_favorite
import com.example.cloudymous.footballclubcloud.R.menu.detail_menu
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.db.FavoriteTeam
import com.example.cloudymous.footballclubcloud.db.databaseFavoriteTeam
import com.example.cloudymous.footballclubcloud.model.Team
import com.example.cloudymous.footballclubcloud.pageradapter.DetailTeamPagerAdapter
import com.example.cloudymous.footballclubcloud.presenter.DetailTeamPresenter
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast
import java.sql.SQLClientInfoException

class DetailTeamActivity : AppCompatActivity(), DetailTeamView {

    private lateinit var presenter: DetailTeamPresenter
    private lateinit var team: Team

    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var teamId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        supportActionBar?.title = "Team Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        teamId = intent.getStringExtra("teamId")

        favState()

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailTeamPresenter(this, request, gson)
        presenter.getDetailTeam(teamId)

        team_pager_main.adapter = DetailTeamPagerAdapter(supportFragmentManager)
        tabs_team.setupWithViewPager(team_pager_main)


    }

    fun getTeamId(): String {
        return teamId
    }

    private fun favState() {
        databaseFavoriteTeam.use {
            val result = select(FavoriteTeam.TABLE_FAVORITE)
                .whereArgs("(TEAM_ID = {id)", "id" to teamId)

            val favorite = result.parseList(classParser<FavoriteTeam>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
        setFav()
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
                if (isFavorite) removeFromFav() else addToFavorite()
                isFavorite = !isFavorite
                setFav()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showTeamDetail(data: List<Team>) {

        team = Team(
            data[0].teamId,
            data[0].teamName,
            data[0].teamBadge,
            data[0].teamFormatYear,
            data[0].teamStadium,
            data[0].teamDescription
        )

        Picasso.get().load(data[0].teamBadge).into(team_badge)
        team_name.text = data[0].teamName
        team_formed_year.text = data[0].teamFormatYear
        team_stadium.text = data[0].teamStadium
    }

    private fun addToFavorite() {
        try {
            databaseFavoriteTeam.use {
                insert(
                    FavoriteTeam.TABLE_FAVORITE,
                    FavoriteTeam.TEAM_ID to team.teamId,
                    FavoriteTeam.TEAM_NAME to team.teamName,
                    FavoriteTeam.TEAM_BADGE to team.teamBadge
                )
            }
            toast("Add to Favorite")
        } catch (e: SQLClientInfoException) {
            toast(e.localizedMessage)
        }
    }

    private fun removeFromFav() {
        try {
            databaseFavoriteTeam.use {
                delete(FavoriteTeam.TABLE_FAVORITE, "TEAM_ID = {id}", "id" to teamId)
            }
            toast("Remove from Favorite")
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
