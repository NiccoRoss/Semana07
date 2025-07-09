package com.example.weekgineer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class CardAdapter(
    private val items: List<CardData>,
    private val onClick: (View, CardData) -> Unit
) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title)
        val subhead = view.findViewById<TextView>(R.id.subhead)
        val infoText = view.findViewById<TextView>(R.id.infoText)
        val icon = view.findViewById<ImageView>(R.id.ivSemana)
        val card = view.findViewById<MaterialCardView>(R.id.card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.subhead.text = item.subhead
        holder.infoText.text = item.infoText
        holder.icon.setImageResource(item.imageResId)
        holder.card.transitionName = "card_transition_${position}"
        holder.card.setOnClickListener {
            onClick(holder.card, item) }
    }

    override fun getItemCount(): Int = items.size
}
