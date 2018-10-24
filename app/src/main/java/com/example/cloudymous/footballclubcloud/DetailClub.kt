package com.example.cloudymous.footballclubcloud

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailClubUI().setContentView(this)

    }

    class DetailClubUI : AnkoComponent<DetailClub> {

        private var namaClubExtra: String = ""
        private var deskripsiClubExtra: String = ""
        private lateinit var namaClubTV: TextView
        private lateinit var deskripsiClubTV: TextView
        val intent = intent

        override fun createView(ui: AnkoContext<DetailClub>) = with(ui) {

            verticalLayout {
                padding = dip(16)

                namaClubTV = textView() {
                    textSize = 20f
                    textColor = Color.BLACK
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }


                deskripsiClubTV = textView("Club Impian ada di tengah peluh") {
                    textColor = Color.BLACK
                }

                namaClubExtra = intent.getStringExtra("namaClubExt")
                deskripsiClubExtra = intent.getStringExtra("deskripsiClub")

                namaClubTV.text = namaClubExtra
                deskripsiClubTV.text = deskripsiClubExtra

            }

        }
    }

}

