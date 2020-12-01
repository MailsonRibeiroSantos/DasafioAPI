package com.mailsonribeiro.desafioapi.listagem.model

import com.google.gson.annotations.SerializedName

data class DataModel ( @SerializedName("type")
                  val tipo: String,
                  @SerializedName("date")
                  val data: String)