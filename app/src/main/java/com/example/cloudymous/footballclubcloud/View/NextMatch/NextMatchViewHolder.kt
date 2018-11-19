package com.example.cloudymous.footballclubcloud.View.NextMatch

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.Utils.formatDate
import com.example.cloudymous.footballclubcloud.Utils.formatTime
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class NextMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(nextmatch: DetailMatch, clickListener: (DetailMatch) -> Unit) {
        home.text = nextmatch.homeTeam
        away.text = nextmatch.awayTeam
        date_match.text = formatDate(nextmatch.eventDate)
        time_match.text = formatTime(nextmatch.eventTime)

        itemView.onClick { clickListener(nextmatch) }
    }
}