package com.example.cloudymous.footballclubcloud.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.model.Player
import com.example.cloudymous.footballclubcloud.presenter.DetailPlayerPresenter
import com.example.cloudymous.footballclubcloud.ui.view.DetailPlayerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_player.*

class DetailPlayerActivity : AppCompatActivity(),
    DetailPlayerView {

    private lateinit var presenter: DetailPlayerPresenter
    private lateinit var playerId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        supportActionBar?.title = "Player Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        playerId = intent.getStringExtra("playerId")

        val request = ApiRepository()
        val gson = Gson()

        presenter = DetailPlayerPresenter(this, request, gson)
        presenter.getPlayerDetail(playerId)

    }

    override fun showPlayerDetail(data: List<Player>) {

        Picasso.get().load(data[0].playerThumb).into(player_banner)
        player_name.text = data[0].playerName
        player_weight.text = data[0].playerWeight
        player_height.text = data[0].playerHeight
        player_position.text = data[0].playerPosition
        player_detail.text = data[0].playerDescription

    }

}
