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
        MainMenuUI().setContentView(this)
        loadData()

//        val adapter: ClubAdapter = ClubAdapter(ArrayList<Clubs>())
//        MainMenuUI(adapter).setContentView(this)

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

    private fun loadData() {
        val nama = resources.getStringArray(club_name)
        val desc = resources.getStringArray(club_desc)
        val image = resources.obtainTypedArray(club_image)

        clubs.clear()

        for (i in nama.indices) {
            clubs.add(Clubs(nama[i], desc[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }


}
