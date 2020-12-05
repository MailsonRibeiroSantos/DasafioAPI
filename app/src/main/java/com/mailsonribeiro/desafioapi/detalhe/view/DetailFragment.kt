package com.mailsonribeiro.desafioapi.detalhe.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.mailsonribeiro.desafioapi.R
import com.mailsonribeiro.desafioapi.detalhe.model.PrecoModel
import com.mailsonribeiro.desafioapi.listagem.model.DataModel
import com.mailsonribeiro.desafioapi.listagem.model.ImagemModel
import com.mailsonribeiro.desafioapi.listagem.view.HomeFragment
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val descircao = arguments?.getString(HomeFragment.COMICS_DESCRICAO)
        val titulo = arguments?.getString(HomeFragment.COMICS_TITULO)
        val datas = arguments?.get(HomeFragment.COMICS_DATAS) as List<DataModel>
        val precos = arguments?.get(HomeFragment.COMICS_PRECO) as List<PrecoModel>
        val pagina = arguments?.getInt(HomeFragment.COMICS_PAGE)
        val imagens = arguments?.get(HomeFragment.COMICS_IMAGENS) as List<ImagemModel>
        val miniatura = arguments?.getString(HomeFragment.COMICS_MINIATURA)


        val imagemMiniatura = view.findViewById<ImageView>(R.id.ivImagemMiniatura)
        val imagemLandscape = view.findViewById<ImageView>(R.id.ivImageViewLandscape)
        val tvTitulo = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        val tvPublishedDetail = view.findViewById<TextView>(R.id.tvPublishedDetail)
        val tvPriceDetail = view.findViewById<TextView>(R.id.tvPriceDetail)
        val tvPageDetail = view.findViewById<TextView>(R.id.tvPageDetail)

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
        tvTitulo.text = titulo.toString().toUpperCase()

        if(descircao !=null) {
            tvDescription.text = descircao.toString()
        }

        if(descircao !=null) {
            tvDescription.text = descircao.toString()
        }

        if(pagina != null){
            tvPageDetail.text = pagina.toString()
        }

        if (precos != null) {
            tvPriceDetail.text = "$ " + precos[0].preco.toString()
        }
        if (datas != null) {

            tvPublishedDetail.text =  datas[0].data
        }

    }
}