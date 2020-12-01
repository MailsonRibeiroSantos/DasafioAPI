package com.mailsonribeiro.desafioapi.listagem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.mailsonribeiro.desafioapi.listagem.model.ComicsModel
import com.mailsonribeiro.desafioapi.listagem.repository.ComicRepository
import kotlinx.coroutines.Dispatchers

class ComicViewModel (private val repository: ComicRepository): ViewModel(){
    private var _listaComics: List<ComicsModel> = listOf()
    fun getListagem() = liveData(Dispatchers.IO){
        val response = repository.getComics()
        _listaComics = response.data.results
        emit(response.data.results)

    }

    class ComicViewModelFactory(
        private val repository: ComicRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }

}