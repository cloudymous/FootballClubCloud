package com.example.cloudymous.footballclubcloud

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.generated.design.R.attr.colorAccent
import org.jetbrains.anko.generated.design.R.attr.layout_anchorGravity
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.ArrayList

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        initlist()

    }


    class MainActivityUI : AnkoComponent<MainMenu> {
        override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
            linearLayout {
                padding = dip(16)
                onClick{toast("Hellow Motto")}

                imageView {
                    imageResource = R.drawable.img_barca

                }.lparams(dip(50), dip(50))

                textView {
                    text = "Barcelona"
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                }

            }
        }

    }

//    class ListUI : AnkoComponent<MainMenu>{
//        override fun createView(ui:AnkoContext<MainMenu>) = with(ui){
//            linearLayout {
//                padding = dip(16)
//
//                imageView {
//                    imageResource = R.drawable.img_barca
//
//                }.lparams(dip(50), dip(50))
//
//                textView {
//                    text = "Barcelona"
//                }.lparams {
//                    width = wrapContent
//                    height = wrapContent
//                    margin = dip(10)
//                }
//
//            }
//        }
//    }

    private fun initlist() {

        data class ClubFootball(val namaClubs: String, val descriptionClubs: String, val imageClub: Int)

        val clubs: ArrayList<ClubFootball> = ArrayList()
        clubs.add(ClubFootball("AC Milan", "Tim Kesayangan", R.drawable.img_acm))
        clubs.add(ClubFootball("Arsenal", "Tim Kesayangan", R.drawable.img_arsenal))
        clubs.add(ClubFootball("Barcelona", "Tim Kesayangan", R.drawable.img_madrid))
        clubs.add(ClubFootball("Bayern Munchen", "Tim Kesayangan", R.drawable.img_bayern))
        clubs.add(ClubFootball("Chelsea", "Tim Kesayangan", R.drawable.img_chelsea))
        clubs.add(ClubFootball("Manchester City", "Tim Kesayangan", R.drawable.img_city))
        clubs.add(ClubFootball("Manchester United", "Tim Kesayangan", R.drawable.img_mu))
        clubs.add(ClubFootball("Real Madrid", "Tim Kesayangan", R.drawable.img_madrid))
    }

    //            verticalLayout {
//                padding = dip(16)
//
//                val name = editText {
//                    hint = "What's your name?"
//                }
//
//                linearLayout {
//
//                    button("Say Hello") {
//                        textColor = Color.WHITE
//                        onClick { toast("Hello, ${name.text}!") }
//                    }.lparams(weight = 1.0F)
//
//                    button("Say Goodbye") {
//                        textColor = Color.WHITE
//                        onClick { toast("Goodbye, ${name.text}!") }
//                    }.lparams(weight = 1.0F)
//
//                }
//
//                button("Next Intent") {
//                    textColor = Color.WHITE
//                    onClick {
//                        startActivity<DetailClub>()
//                    }
//                }
//
//                button("Say Hello") {
//                    textColor = Color.WHITE
//                    onClick {
//                        alert("Happy Coding!", "Hello, ${name.text}!") {
//                            yesButton { toast("Oh…") }
//                            noButton {}
//                        }.show()
//                    }
//                }.lparams(width = matchParent) {
//                    topMargin = dip(5)
//                }
//
//
//                button("Show Selector") {
//                    textColor = Color.WHITE
//                    onClick {
//                        val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
//                        selector("Hello, ${name.text}! What's football club do you love?", club) { _, i ->
//                            toast("So you love ${club[i]}, right?")
//                        }
//                    }
//                }.lparams(width = matchParent) {
//                    topMargin = dip(5)
//                }
//            }


}
