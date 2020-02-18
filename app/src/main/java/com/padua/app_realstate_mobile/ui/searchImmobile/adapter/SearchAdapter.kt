package com.padua.app_realstate_mobile.ui.searchImmobile.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.network.bean.ImmobileResponse
import kotlinx.android.synthetic.main.item_immobile.view.*

class SearchAdapter(private val items: List<ImmobileResponse>,
                    private val context: Context): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_immobile, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val immobile = items[position]
        holder.price?.text = "R$" + immobile.preco.toString()
        holder.city?.text = immobile.cidade + " " + "/" + " " + immobile.estado
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val price: TextView? = itemView.item_valor
        val city: TextView? = itemView.item_city
    }


}

