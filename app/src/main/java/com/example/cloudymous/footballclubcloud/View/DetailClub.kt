package com.example.cloudymous.footballclubcloud.View

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    private var namaClubExtra: String = ""
    private var deskripsiClubExtra: String = ""
    private lateinit var namaClubTV: TextView
    private lateinit var deskripsiClubTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            namaClubTV = textView() {
                textSize = 20f
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }


            deskripsiClubTV = textView() {
                textColor = Color.BLACK
            }

        }

        val intent = intent
        namaClubExtra = intent.getStringExtra("namaClubExt")
        deskripsiClubExtra = intent.getStringExtra("deskClubExt")

        namaClubTV.text = namaClubExtra
        deskripsiClubTV.text = deskripsiClubExtra

    }
}


