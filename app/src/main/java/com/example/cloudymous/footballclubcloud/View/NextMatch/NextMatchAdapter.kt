package com.example.cloudymous.footballclubcloud.View.NextMatch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloudymous.footballclubcloud.Model.DetailMatch
import com.example.cloudymous.footballclubcloud.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_match.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class NextMatchAdapter(
    private val context: Context,
    private val nextmatch: List<DetailMatch>,
    private val clickListener: (DetailMatch) -> Unit
) :
    RecyclerView.Adapter<NextMatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder =
        NextMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.list_match, parent, false))

    override fun getItemCount(): Int = nextmatch.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.bindItem(nextmatch[position], clickListener)
    }

}

class NextMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(nextmatch: DetailMatch, clickListener: (DetailMatch) -> Unit) {
        home.text = nextmatch.homeTeam
        away.text = nextmatch.awayTeam
        time.text = nextmatch.eventDate

        itemView.onClick { clickListener(nextmatch) }
    }
}