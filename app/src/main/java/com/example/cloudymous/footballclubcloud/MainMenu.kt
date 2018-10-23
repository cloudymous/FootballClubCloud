package com.example.cloudymous.footballclubcloud


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainMenuUI().setContentView(this)

    }

    class MainMenuUI : AnkoComponent<MainMenu> {
        override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
            linearLayout {
                padding = dip(16)

                imageView {
                    setImageResource(R.drawable.img_madrid)
                }.lparams(width = dip(50), height = dip(50))

                val namaClub = textView("Real Madrid"){
                    gravity = Gravity.CENTER_VERTICAL
                }

                onClick { startActivity<DetailClub>("namaClubExt" to "${namaClub.text}", "deskripsiClub" to "Impian Ada di tengah peluh" ) }

            }
        }
    }



}
