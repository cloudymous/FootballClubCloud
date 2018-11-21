package com.example.cloudymous.footballclubcloud.view.lastmatch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.R

class LastMatchAdapter(
    private val context: Context,
    private val lastmatch: List<DetailMatch>,
    private val clickListener: (DetailMatch) -> Unit
) :
    RecyclerView.Adapter<LastMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LastMatchViewHolder =
        LastMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.list_match, parent, false))

    override fun getItemCount(): Int = lastmatch.size

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(lastmatch[position], clickListener)
    }

}