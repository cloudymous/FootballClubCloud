package com.example.cloudymous.footballclubcloud.View.NextMatch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Model.NextMatch
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*

class NextMatchAdapter (private val context: Context, private val nextmatch : List<NextMatch>, private val clickListener: (NextMatch) -> Unit) :
    RecyclerView.Adapter<NextMatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder =
        NextMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.list_match, parent, false))

    override fun getItemCount(): Int = nextmatch.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.bindItem(nextmatch[position], clickListener)
    }

}

class NextMatchViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    fun bindItem (nextmatch: NextMatch, clickListener: (NextMatch) -> Unit){
        home.text = nextmatch.teamHome
        away.text = nextmatch.teamAway
        time.text = nextmatch.eventDate

        containerView.setOnClickListener { clickListener(nextmatch) }
    }
}