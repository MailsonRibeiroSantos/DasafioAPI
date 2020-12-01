package com.mailsonribeiro.desafioapi.listagem.repository

class ComicRepository {
    private val client = IComicEndPoint.endpoint
    suspend fun getComics(offset: Int? = 0) = client.getComics(offset)
}

