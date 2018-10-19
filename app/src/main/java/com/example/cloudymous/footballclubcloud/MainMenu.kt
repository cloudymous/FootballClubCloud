package com.example.cloudymous.footballclubcloud

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.generated.design.R.attr.colorAccent
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainMenu> {
        override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
            verticalLayout {
                padding = dip(16)

                val name = editText {
                    hint = "What's your name?"
                }

                linearLayout {

                    button("Say Hello") {
                        textColor = Color.WHITE
                        onClick { toast("Hello, ${name.text}!") }
                    }.lparams(weight = 1.0F)

                    button("Say Goodbye") {
                        textColor = Color.WHITE
                        onClick { toast("Goodbye, ${name.text}!") }
                    }.lparams(weight = 1.0F)

                }

                button("Next Intent") {
                    textColor = Color.WHITE
                    onClick {
                        startActivity<DetailClub>()
                    }
                }

                button("Say Hello") {
                    textColor = Color.WHITE
                    onClick {
                        alert("Happy Coding!", "Hello, ${name.text}!") {
                            yesButton { toast("Oh…") }
                            noButton {}
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }


                button("Show Selector") {
                    textColor = Color.WHITE
                    onClick {
                        val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                        selector("Hello, ${name.text}! What's football club do you love?", club) { _, i ->
                            toast("So you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
            }
        }

    }
}
