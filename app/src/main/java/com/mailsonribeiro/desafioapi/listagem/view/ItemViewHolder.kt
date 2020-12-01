package com.mailsonribeiro.desafioapi.listagem.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mailsonribeiro.desafioapi.R
import com.mailsonribeiro.desafioapi.listagem.model.ComicsModel
import com.squareup.picasso.Picasso

class ItemViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val numero = view.findViewById<TextView>(R.id.tvNameCard)
    private val imagem = view.findViewById<ImageView>(R.id.ivImageCard)

    fun bind(comicsModel: ComicsModel){
        numero.text = "# ${comicsModel.id}"

        val path = comicsModel.miniatura.getImagePath("detail")
        Picasso.get().load(path).into(imagem)
    }

}