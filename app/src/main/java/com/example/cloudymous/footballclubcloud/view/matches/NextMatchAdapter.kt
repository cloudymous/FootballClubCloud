package com.example.cloudymous.footballclubcloud.view.matches

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.R
import com.example.cloudymous.footballclubcloud.model.DetailMatch

class NextMatchAdapter(
    private val context: Context,
    private val nextmatch: List<DetailMatch>,
    private val clickListener: (DetailMatch) -> Unit
) :
    RecyclerView.Adapter<NextMatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder =
        NextMatchViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_match,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = nextmatch.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.bindItem(nextmatch[position], clickListener)
    }

}