package com.example.cloudymous.footballclubcloud.View

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.cloudymous.footballclubcloud.R
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    private var namaClubExtra: String = ""
    private var deskripsiClubExtra: String = ""
    private var imageClubExtra: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            val intent = intent
            imageClubExtra = intent.getIntExtra("imgClubExtra", 0)
            namaClubExtra = intent.getStringExtra("namaClubExt")
            deskripsiClubExtra = intent.getStringExtra("deskClubExt")

            imageView{
                setImageResource(imageClubExtra)
            }.lparams{
                width = dip(50)
                height = dip (50)
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView(namaClubExtra) {
                textSize = 20f
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }


            textView(deskripsiClubExtra) {
                textColor = Color.BLACK
            }

        }

    }
}


