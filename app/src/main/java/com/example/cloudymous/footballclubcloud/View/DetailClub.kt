package com.example.cloudymous.footballclubcloud.View

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.example.cloudymous.footballclubcloud.Club.Clubs
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            val intent = intent
            val clubDetail = intent.getParcelableExtra<Clubs>("ClubExtra")

            imageView{
                setImageResource(clubDetail.imageClub)
            }.lparams{
                width = dip(50)
                height = dip (50)
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView(clubDetail.namaClub) {
                textSize = 20f
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }


            textView(clubDetail.deskripsiClub) {
                textColor = Color.BLACK
            }

        }

    }
}


