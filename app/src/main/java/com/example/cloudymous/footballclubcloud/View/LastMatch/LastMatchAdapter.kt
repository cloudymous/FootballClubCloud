package com.example.cloudymous.footballclubcloud.View.LastMatch

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.cloudymous.footballclubcloud.Model.LastMatch
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match_experimental.*
import org.jetbrains.anko.*

class LastMatchAdapter (private val context: Context, private val lastmatch : List<LastMatch>) :
    RecyclerView.Adapter<LastMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LastMatchViewHolder =
        LastMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.list_match_experimental, parent, false))

    override fun getItemCount(): Int = lastmatch.size

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(lastmatch[position])
    }

}

class LastMatchViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(lastmatch: LastMatch) {
        home.text = lastmatch.homeTeam
        home_score.text = lastmatch.homeScore
        away.text = lastmatch.awayTeam
        away_score.text = lastmatch.awayScore
        time.text = lastmatch.eventDate
    }

}