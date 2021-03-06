package com.example.cloudymous.footballclubcloud.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.utils.formatDate
import com.example.cloudymous.footballclubcloud.utils.formatTime
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(match: DetailMatch, clickListener: (DetailMatch) -> Unit) {

        date_match.text = formatDate(match.eventDate)

        time_match.text = formatTime(match.eventTime)

        home.text = match.homeTeam
        home_score.text = match.homeScore

        away.text = match.awayTeam
        away_score.text = match.awayScore

        itemView.onClick { clickListener(match) }
    }
}