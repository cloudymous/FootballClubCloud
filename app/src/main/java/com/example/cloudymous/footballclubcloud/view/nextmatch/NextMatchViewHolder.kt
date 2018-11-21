package com.example.cloudymous.footballclubcloud.view.nextmatch

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import kotlinx.android.extensions.LayoutContainer

class NextMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(nextmatch: DetailMatch, clickListener: (DetailMatch) -> Unit) {
        home.text = nextmatch.homeTeam
        away.text = nextmatch.awayTeam
        date_match.text = formatDate(nextmatch.eventDate)
        time_match.text = formatTime(nextmatch.eventTime)

        itemView.onClick { clickListener(nextmatch) }
    }
}