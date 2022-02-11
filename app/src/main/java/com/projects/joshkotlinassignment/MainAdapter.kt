package com.projects.joshkotlinassignment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val clickCount: Int, private val itemList: List<ItemsViewModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_list, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = itemList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.listValue.toString()

        // check click to swap the background colors
        if (clickCount % 2 != 0)
            if (itemsViewModel.listValue % 2 != 0)
                holder.contentLayout.setBackgroundColor(Color.parseColor("#66C14A44"));
            else
                holder.contentLayout.setBackgroundColor(Color.parseColor("#8DB8D9"));
        else
            if (itemsViewModel.listValue % 2 != 0)
                holder.contentLayout.setBackgroundColor(Color.parseColor("#8DB8D9"));
            else
                holder.contentLayout.setBackgroundColor(Color.parseColor("#66C14A44"));

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val contentLayout: RelativeLayout = itemView.findViewById(R.id.contentLayout)
        val textView: TextView = itemView.findViewById(R.id.textView)

    }

}