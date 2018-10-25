package com.example.cloudymous.footballclubcloud

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.AnkoContext


class RecyclerViewAdapter(private val context: Context, private val items: List<Clubs>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(ListClubUI, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(R.id.name)
        private val deskripsi = view.findViewById<TextView>(R.id.desk)
        private val gambar = view.findViewById<ImageView>(R.id.gambar)

        fun bindItem(items: Clubs) {
            name.text = items.name
            items.?.let { Picasso.get().load(it).into(gambar) }
        }
    }
}