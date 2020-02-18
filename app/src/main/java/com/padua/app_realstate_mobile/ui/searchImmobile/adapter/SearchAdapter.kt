package com.padua.app_realstate_mobile.ui.searchImmobile.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.network.bean.ImmobileResponse
import com.padua.app_realstate_mobile.ui.searchImmobile.SearchImmobileActivity
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.item_immobile.view.*

class SearchAdapter(private val items: List<ImmobileResponse>,
                    private val context: Context, private val activity: SearchImmobileActivity):
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_immobile, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.button?.let { Utils.setPushDownAnimation(it) }
        val immobile = items[position]

        holder.price?.text = "R$" + immobile.preco.toString()
        holder.city?.text = immobile.cidade + " " + "/" + " " + immobile.estado

        holder.button?.setOnClickListener {
            activity.openDialog(immobile)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val price: TextView? = itemView.item_valor
        val city: TextView? = itemView.item_city
        val button: RelativeLayout? = itemView.button_detalhes
    }

}

