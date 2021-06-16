package com.mawatani.daystill.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mawatani.daystill.R
import com.mawatani.daystill.database.EventItem

class DaysTillAdapter : ListAdapter<EventItem, DaysTillAdapter.DaysTillViewHolder>(DaysTillComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysTillViewHolder {
        return DaysTillViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: DaysTillViewHolder, position: Int) {
        val current  = getItem(position)
        val dateCreated = current.dateCreated

        // TODO: 16/6/21 add the date conversion for database and date format for recyclerview
    }

    class DaysTillViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {
        //dueDate
        private val eventDate : TextView = itemVIew.findViewById(R.id.dueDateTV)
        //days remaining till event
        private  val eventDaysRemaining : TextView = itemVIew.findViewById(R.id.daysTillEventTV)
        //title of event
        private val eventTitle : TextView = itemVIew.findViewById(R.id.eventTitleTV)

        fun bind(dateText : String?, daysRem: String?, titleText : String?){
            eventDate.text = dateText
            eventDaysRemaining.text = daysRem
            eventTitle.text = titleText
        }

        companion object{
            fun create(parent: ViewGroup) : DaysTillViewHolder{
                val view : View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_item,parent,false)
                return DaysTillViewHolder(view)
            }
        }
    }

    class DaysTillComparator : DiffUtil.ItemCallback<EventItem>(){
        override fun areItemsTheSame(oldItem: EventItem, newItem: EventItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EventItem, newItem: EventItem): Boolean {
            return  oldItem == newItem
        }

    }


}