package com.example.cloudymous.footballclubcloud.View.LastMatch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.Utils.formatDate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LastMatchAdapter(
    private val context: Context,
    private val lastmatch: List<DetailMatch>,
    private val clickListener: (DetailMatch) -> Unit
) :
    RecyclerView.Adapter<LastMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LastMatchViewHolder =
        LastMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.list_match, parent, false))

    override fun getItemCount(): Int = lastmatch.size

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(lastmatch[position], clickListener)
    }

}

class LastMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(lastmatch: DetailMatch, clickListener: (DetailMatch) -> Unit) {

        date_match.text = formatDate(lastmatch.eventDate)

        home.text = lastmatch.homeTeam
        home_score.text = lastmatch.homeScore

        away.text = lastmatch.awayTeam
        away_score.text = lastmatch.awayScore

        itemView.onClick { clickListener(lastmatch) }
    }
}