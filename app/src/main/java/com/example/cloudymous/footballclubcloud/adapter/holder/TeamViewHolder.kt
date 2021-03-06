package com.example.cloudymous.footballclubcloud.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.model.Team
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_team.*

class TeamViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {


    fun bindItem(teams: Team, listener: (Team) -> Unit) {
        Picasso.get().load(teams.teamBadge).into(team_badge)
        team_name.text = teams.teamName
        itemView.setOnClickListener { listener(teams) }
    }
}