package com.mailsonribeiro.desafioapi.listagem.model

import com.google.gson.annotations.SerializedName
import com.mailsonribeiro.desafioapi.detalhe.model.MiniaturaModel
import com.mailsonribeiro.desafioapi.detalhe.model.PrecoModel
import com.mailsonribeiro.desafioapi.listagem.model.DataModel
import com.mailsonribeiro.desafioapi.listagem.model.ImagemModel

class ComicsModel(@SerializedName("id")
                   val id: Int,
                  @SerializedName("title")
                   val titulo: String,
                  @SerializedName("issueNumber")
                   val numeroEdicao: Double,
                  @SerializedName("description")
                   val descricao: String,
                  @SerializedName("pageCount")
                   val pagina: Int,
                  @SerializedName("dates")
                   val datas: List<DataModel>,
                  @SerializedName("prices")
                   val precos: List<PrecoModel>,
                  @SerializedName("thumbnail")
                   val miniatura: MiniaturaModel,
                  @SerializedName("images")
                   val imagens: List<ImagemModel>)