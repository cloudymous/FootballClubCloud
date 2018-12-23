package com.example.cloudymous.footballclubcloud.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.holder.TeamViewHolder
import com.example.cloudymous.footballclubcloud.model.Team

class TeamsAdapter(
    private val context: Context,
    private val teams: List<Team>,
    private val listener: (Team) -> Unit
) :
    RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TeamViewHolder =
        TeamViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_team,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    override fun getItemCount(): Int = teams.size

}