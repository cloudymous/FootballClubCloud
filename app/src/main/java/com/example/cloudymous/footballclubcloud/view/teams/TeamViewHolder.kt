package com.example.cloudymous.footballclubcloud.view.teams

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(R.id.team_badge)
    private val teamName: TextView = view.find(R.id.team_name)

    fun bindItem(teams: Team, listener: (Team) -> Unit) {
        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName
        itemView.setOnClickListener { listener(teams) }
    }
}