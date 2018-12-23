package com.example.cloudymous.footballclubcloud.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.cloudymous.footballclubcloud.model.Player
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_player.*

class TeamPlayerViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bindItem(players: Player, clickListener: (Player) -> Unit) {
        Picasso.get().load(players.playerImage).into(player_photo)
        player_name.text = players.playerName
        player_position.text = players.playerPosition
        itemView.setOnClickListener { clickListener(players) }
    }
}