package com.example.cloudymous.footballclubcloud

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.*


class ClubAdapter (private val context: Context, private val items: List<Clubs>, private val listener: (Clubs) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(ListClubUI(), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener )
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(items: Clubs, listener: (Clubs) -> Unit) {

        }

    }

}