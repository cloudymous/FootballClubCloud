package com.example.cloudymous.footballclubcloud


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.example.cloudymous.footballclubcloud.R.array.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainMenu : AppCompatActivity() {

    private val clubs: MutableList<Clubs> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        MainMenuUI().setContentView(this)

        val adapter: ClubAdapter = ClubAdapter(ArrayList<Clubs>())
        MainMenuUI(adapter).setContentView(this)

    }

    class MainMenuUI : AnkoComponent<MainMenu> {

        override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)

                recyclerView {
                    lparams(width = matchParent, height = wrapContent)
                    layoutManager = LinearLayout(ctx)
                    adapter = mAdapter
                }
            }
        }
    }

    class ListClubUI : AnkoComponent<MainMenu> {

        val IdImageView = 1
        val IdClubName = 2

        override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
            var list_club = linearLayout {
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
            }
        }
    }

    private fun loadData(){
        val nama = resources.getStringArray(club_name)
        val desc = resources.getStringArray(club_desc)
        val image = resources.obtainTypedArray(club_image)

        clubs.clear()

        for (i in nama.indices){
            clubs.add(Clubs(nama[i], desc[i], image.getResourceId(i,0)))
        }

        image.recycle()
    }



}
