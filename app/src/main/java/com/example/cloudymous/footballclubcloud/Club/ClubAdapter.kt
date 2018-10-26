package com.example.cloudymous.footballclubcloud.Club

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.example.cloudymous.footballclubcloud.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class ClubAdapter(private val context: Context, private val items: List<Clubs>, private val listener: (Clubs) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.TeamViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            ListClubUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(R.id.nama_club)
        private val gambar = view.findViewById<ImageView>(R.id.gambar_club)

        fun bindItem(items: Clubs, listener: (Clubs) -> Unit) {

            name.text = items.namaClub
            items.imageClub?.let { Picasso.get().load(it).resize(100,100).into(gambar) }
            itemView.setOnClickListener{
                listener(items)
            }

        }
    }
}

class ListClubUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(8)
            id = R.id.list_club

            imageView {
                id = R.id.gambar_club
                //setImageResource(R.drawable.img_madrid)
            }
//                .lparams(width = dip(50), height = dip(50))

            textView() {
                id = R.id.nama_club
                textSize = 18f
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams {
                gravity = Gravity.CENTER_VERTICAL
                marginStart = dip(16)
            }
        }
    }
}

