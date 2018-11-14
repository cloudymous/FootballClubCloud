package com.example.cloudymous.footballclubcloud.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Model.Team
import org.jetbrains.anko.*

class TeamAdapter(private val teams: List<Team>, private val listener: (Team) -> Unit) :
    RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            TeamUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)

    }
}