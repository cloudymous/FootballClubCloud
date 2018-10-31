package com.example.cloudymous.footballclubcloud.Presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.cloudymous.footballclubcloud.Model.LastMatch
import com.example.cloudymous.footballclubcloud.R
import org.jetbrains.anko.*

class LastMatchAdapter (private val lastmatch : List<LastMatch>) : RecyclerView.Adapter<LastMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LastMatchViewHolder {
        return LastMatchViewHolder(LastMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = lastmatch.size

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(lastmatch[position])
    }

}

class LastMatchViewHolder (view: View) : RecyclerView.ViewHolder(view){

    private val lastEventName: TextView = view.find(R.id.event_name)

    fun bindItem(lastmatch: LastMatch) {
        lastEventName.text = lastmatch.eventName
    }

}

class LastMatchUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                textView {
                    id = R.id.event_name
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }

            }
        }
    }
}