package com.example.bottomnavigation.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.R
import com.example.bottomnavigation.RemoteModel.FullTolerance


class ToleranceAdapter(
    val fullTolerances: MutableList<FullTolerance>,
    val activity: All
) :
    RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.tolerance_cart, parent, false)
            val holder = MyViewHolder(itemView)
            holder.itemView.setOnLongClickListener {
               activity.onLongClick(holder.adapterPosition)
                return@setOnLongClickListener true
            }
        return holder
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.size.text = fullTolerances[position].size
        holder.up_variation.text = fullTolerances[position].toleranceUp.toString()+" мм"
        holder.dw_variation.text = fullTolerances[position].toleranceDw.toString()+" мм"
        holder.up_size.text = fullTolerances[position].fullToleranceUp.toString()+" мм"
        holder.dw_size.text = fullTolerances[position].fullToleranceDw.toString()+" мм"

    }

    override fun getItemCount(): Int {
        return fullTolerances.size
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val size = itemView.findViewById<TextView>(R.id.size)
    val up_variation = itemView.findViewById<TextView>(R.id.up_variation)
    val dw_variation = itemView.findViewById<TextView>(R.id.dw_variation)
    val up_size = itemView.findViewById<TextView>(R.id.up_size)
    val dw_size = itemView.findViewById<TextView>(R.id.dw_size)
}







