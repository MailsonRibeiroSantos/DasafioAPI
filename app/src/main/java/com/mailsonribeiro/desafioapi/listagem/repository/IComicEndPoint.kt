package com.mailsonribeiro.desafioapi.listagem.repository

import com.mailsonribeiro.desafioapi.data.api.NetworkUtils
import com.mailsonribeiro.desafioapi.data.model.ResponseModel
import com.mailsonribeiro.desafioapi.listagem.model.ComicsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface IComicEndPoint {
    @GET("/v1/public/comics")
    suspend fun getComics(@Query("offset") offset: Int? = 0): ResponseModel<ComicsModel>

    companion object {
        val endpoint: IComicEndPoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IComicEndPoint::class.java)
        }
    }
}