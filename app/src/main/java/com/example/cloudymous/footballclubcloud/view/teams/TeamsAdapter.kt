package com.example.cloudymous.footballclubcloud.view.teams

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.model.Team
import org.jetbrains.anko.AnkoContext

class TeamsAdapter(private val teams: List<Team>, private val listener: (Team) -> Unit) :
    RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    override fun getItemCount(): Int = teams.size

}