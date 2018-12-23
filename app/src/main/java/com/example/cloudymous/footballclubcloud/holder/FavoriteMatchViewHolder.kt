package com.example.cloudymous.footballclubcloud.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.cloudymous.footballclubcloud.R.id.*
import com.example.cloudymous.footballclubcloud.db.FavoriteMatch
import com.example.cloudymous.footballclubcloud.utils.formatDate
import com.example.cloudymous.footballclubcloud.utils.formatTime
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

class FavoriteMatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val dateTv: TextView = view.find(date_match)
    private val timeTv: TextView = view.find(time_match)

    private val homeTeamTv: TextView = view.find(home)
    private val awayTeamTv: TextView = view.find(away)

    private val homeScoreTv: TextView = view.find(home_score)
    private val awayScoreTv: TextView = view.find(away_score)

    fun bindItem(favoriteMatch: FavoriteMatch, clickListener: (FavoriteMatch) -> Unit) {

        dateTv.text = formatDate(favoriteMatch.eventDate)

        timeTv.text = formatTime(favoriteMatch.eventTime)

        homeTeamTv.text = favoriteMatch.homeTeam
        homeScoreTv.text = favoriteMatch.homeScore

        awayTeamTv.text = favoriteMatch.awayTeam
        awayScoreTv.text = favoriteMatch.awayScore

        itemView.onClick { clickListener(favoriteMatch) }
    }
}