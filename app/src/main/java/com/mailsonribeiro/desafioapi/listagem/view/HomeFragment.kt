package com.mailsonribeiro.desafioapi.listagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mailsonribeiro.desafioapi.R
import com.mailsonribeiro.desafioapi.listagem.model.ComicsModel
import com.mailsonribeiro.desafioapi.listagem.repository.ComicRepository
import com.mailsonribeiro.desafioapi.listagem.viewmodel.ComicViewModel


class HomeFragment : Fragment() {
    lateinit var _viewModel: ComicViewModel
    lateinit var _view: View
    private lateinit var _listaAdapter: ComicAdapter

    private var _listaComics = mutableListOf<ComicsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var navController = Navigation.findNavController(view)

        _view = view

        val lista = view.findViewById<RecyclerView>(R.id.recycler_view)
        val manager = GridLayoutManager(view.context,3)

        _listaComics = mutableListOf<ComicsModel>()
        _listaAdapter = ComicAdapter(_listaComics){
            navController.navigate(R.id.detailFragment)
        }

        lista.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.getListagem().observe(viewLifecycleOwner, {
            exibirResultados(it)
        })

    }

    private fun exibirResultados(lista: List<ComicsModel>?) {
        lista?.let { _listaComics.addAll(it) }

        _listaAdapter.notifyDataSetChanged()
    }
}