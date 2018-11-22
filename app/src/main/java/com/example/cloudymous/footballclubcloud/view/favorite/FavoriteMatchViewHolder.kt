package com.example.cloudymous.footballclubcloud.view.favorite

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.utils.formatDate
import com.example.cloudymous.footballclubcloud.utils.formatTime
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class FavoriteMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bindItem(favoriteMatch: DetailMatch, clickListener: (DetailMatch) -> Unit) {

        date_match.text = formatDate(favoriteMatch.eventDate)

        time_match.text = formatTime(favoriteMatch.eventTime)

        home.text = favoriteMatch.homeTeam
        home_score.text = favoriteMatch.homeScore

        away.text = favoriteMatch.awayTeam
        away_score.text = favoriteMatch.awayScore

        itemView.onClick { clickListener(favoriteMatch) }
    }
}