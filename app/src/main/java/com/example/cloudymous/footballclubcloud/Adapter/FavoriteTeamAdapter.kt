package com.example.cloudymous.footballclubcloud.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Model.Favorite
import org.jetbrains.anko.*

class FavoriteTeamAdapter(private val favorite: List<Favorite>, private val listener: (Favorite) -> Unit) :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            TeamUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(favorite[position], listener)
    }

    override fun getItemCount(): Int = favorite.size

}