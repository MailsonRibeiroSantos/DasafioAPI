package com.mailsonribeiro.desafioapi.detalhe.model

import com.google.gson.annotations.SerializedName

data class PrecoModel(@SerializedName("type")
                      val tipo: String,
                      @SerializedName("price")
                      val preco: Float)