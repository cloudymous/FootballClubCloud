package com.example.cloudymous.footballclubcloud

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailClubUI().setContentView(this)
    }

    class DetailClubUI : AnkoComponent<DetailClub> {
        override fun createView(ui: AnkoContext<DetailClub>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                textView("Nama Club"){
                    textSize = 20f
                    textColor = Color.BLACK
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }

                textView("Club Impian ada di tengah peluh"){
                    textColor = Color.BLACK
                }
            }
        }

    }
}
