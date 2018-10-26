package com.example.cloudymous.footballclubcloud


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.cloudymous.footballclubcloud.R.array.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainMenu : AppCompatActivity() {

    private val clubs: MutableList<Clubs> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainMenuUI().setContentView(this)

        val list = findViewById<RecyclerView>(R.id.listnya)

        loadData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ClubAdapter(this, clubs){
            startActivity<DetailClub>("namaClubExt" to it.namaClub, "deskClubExt" to it.deskripsiClub)
        }

    }

    class MainMenuUI : AnkoComponent<MainMenu> {

        override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)

                recyclerView {
                    id = R.id.listnya
                    lparams(width = matchParent, height = wrapContent)
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
