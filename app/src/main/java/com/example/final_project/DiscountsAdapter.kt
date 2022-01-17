package com.example.final_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_discounts.view.*

class DiscountsAdapter(val listOfTours: ArrayList<Discounts>, val context: MainActivityDiscounts) : RecyclerView.Adapter<ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_discounts, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.picture.setImageBitmap(listOfTours[position].picture)
        holder.caption.text = listOfTours[position].caption
        holder.price.text = listOfTours[position].price
        holder.description.text = listOfTours[position].description

    }

    override fun getItemCount(): Int {
        return listOfTours.size
    }


}


class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val picture = itemView.ivPicture
    val caption = itemView.tvCaption
    val price = itemView.tvPrice
    val description = itemView.tvTourDescription

}