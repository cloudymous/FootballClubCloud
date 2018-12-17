package com.example.cloudymous.footballclubcloud.view.favorites.teamsfavorite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.db.FavoriteTeam

class FavoriteTeamAdapter(
    private val context: Context,
    private val favorites: List<FavoriteTeam>,
    private val listener: (FavoriteTeam) -> Unit
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
        holder.bindItem(favorites[position], listener)
    }

    override fun getItemCount(): Int = favorites.size
}

