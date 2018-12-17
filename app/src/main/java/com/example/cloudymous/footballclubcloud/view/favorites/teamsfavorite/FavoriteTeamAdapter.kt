package com.example.cloudymous.footballclubcloud.view.favorites.teamsfavorite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.model.Team

class FavoriteTeamAdapter(
    private val context: Context,
    private val teams: List<Team>,
    private val listener: (Team) -> Unit
) :
    RecyclerView.Adapter<FavoriteTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FavoriteTeamViewHolder =
        FavoriteTeamViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_team,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FavoriteTeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    override fun getItemCount(): Int = teams.size
}

