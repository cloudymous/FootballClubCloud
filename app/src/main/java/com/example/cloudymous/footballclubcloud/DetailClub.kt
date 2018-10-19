package com.example.cloudymous.footballclubcloud

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailUI().setContentView(this)
    }

    class DetailUI : AnkoComponent<DetailClub>{
        override fun createView(ui: AnkoContext<DetailClub>) = with(ui){
            verticalLayout {
                textView("Imran"){
                    textColor = Color.BLACK
                }
            }
        }
    }
}
