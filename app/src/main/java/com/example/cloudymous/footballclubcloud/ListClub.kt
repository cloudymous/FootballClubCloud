package com.example.cloudymous.footballclubcloud

import android.graphics.Color
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

class ListClubUI : AnkoComponent<MainMenu> {

    val IdImageView = 1
    val IdClubName = 2

    override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(16)

            imageView {
                id = IdImageView
                setImageResource(R.drawable.img_madrid)
            }.lparams(width = dip(50), height = dip(50))

            textView("Real Madrid"){
                id = IdClubName
                textSize = 18f
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams{
                gravity = Gravity.CENTER_VERTICAL
                marginStart = dip(16)
            }

//            onClick { startActivity<DetailClub>("namaClubExt" to "${namaClub.text}", "deskripsiClub" to "Impian Ada di tengah peluh" ) }

        }
    }
}