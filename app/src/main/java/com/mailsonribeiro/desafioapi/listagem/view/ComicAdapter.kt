package com.mailsonribeiro.desafioapi.listagem.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mailsonribeiro.desafioapi.R
import com.mailsonribeiro.desafioapi.listagem.model.ComicsModel

class ComicAdapter (private val comics: List<ComicsModel>, private val listener: (ComicsModel) -> Unit):
    RecyclerView.Adapter<ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ItemViewHolder(view)
    }
    override fun getItemCount() = comics.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(comics[position])
        holder.itemView.setOnClickListener { listener(comics[position]) }
    }
}
