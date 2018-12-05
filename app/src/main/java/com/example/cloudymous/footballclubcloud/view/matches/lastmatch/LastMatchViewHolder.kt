package com.example.cloudymous.footballclubcloud.view.matches.lastmatch

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.utils.formatDate
import com.example.cloudymous.footballclubcloud.utils.formatTime
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LastMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(lastmatch: DetailMatch, clickListener: (DetailMatch) -> Unit) {

        date_match.text = formatDate(lastmatch.eventDate)

        time_match.text = formatTime(lastmatch.eventTime)

        home.text = lastmatch.homeTeam
        home_score.text = lastmatch.homeScore

        away.text = lastmatch.awayTeam
        away_score.text = lastmatch.awayScore

        itemView.onClick { clickListener(lastmatch) }
    }
}