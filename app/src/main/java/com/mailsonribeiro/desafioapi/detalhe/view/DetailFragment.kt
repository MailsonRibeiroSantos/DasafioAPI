package com.mailsonribeiro.desafioapi.detalhe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.mailsonribeiro.desafioapi.R
import com.mailsonribeiro.desafioapi.detalhe.model.MiniaturaModel
import com.mailsonribeiro.desafioapi.listagem.model.ImagemModel
import com.mailsonribeiro.desafioapi.listagem.view.HomeFragment
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val descircao = arguments?.getString(HomeFragment.COMICS_DESCRICAO)
        val titulo = arguments?.getString(HomeFragment.COMICS_TITULO)
        val datas = arguments?.get(HomeFragment.COMICS_DATAS)
        val precos = arguments?.get(HomeFragment.COMICS_PRECO)
        val imagens = arguments?.get(HomeFragment.COMICS_IMAGENS) as List<ImagemModel>
        val miniatura = arguments?.getString(HomeFragment.COMICS_MINIATURA)


        val imagemMiniatura = view.findViewById<ImageView>(R.id.ivImagemMiniatura)
        val imagemLandscape = view.findViewById<ImageView>(R.id.ivImageViewLandscape)
        val imagemBack = view.findViewById<ImageView>(R.id.ivBackDetalhe)

        var navController = Navigation.findNavController(view)

        Picasso.get().load(miniatura).into(imagemMiniatura)
        var path =imagens[imagens.size-1].getImagePath("landscape_incredible")

        Picasso.get().load(path).into(imagemLandscape)

        imagemBack.setOnClickListener {
            navController.popBackStack()
        }
        imagemMiniatura.setOnClickListener {
            val bundle = bundleOf(
                HomeFragment.COMICS_MINIATURA to miniatura
            )
            navController.navigate(R.id.fullScreenFragment,bundle)
        }

    }
}