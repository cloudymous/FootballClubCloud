package com.example.cloudymous.footballclubcloud.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.adapter.holder.TeamPlayerViewHolder
import com.example.cloudymous.footballclubcloud.model.Player

class TeamPlayerAdapter(
    private val context: Context,
    private val players: List<Player>,
    private val listener: (Player) -> Unit
) :

    RecyclerView.Adapter<TeamPlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TeamPlayerViewHolder =
        TeamPlayerViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_player,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TeamPlayerViewHolder, position: Int) {
        holder.bindItem(players[position], listener)
    }

    override fun getItemCount(): Int = players.size

}