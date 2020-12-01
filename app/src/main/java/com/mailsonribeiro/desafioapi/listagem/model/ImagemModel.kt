package com.mailsonribeiro.desafioapi.listagem.model

import com.google.gson.annotations.SerializedName

data class ImagemModel(@SerializedName("path")
                       val path: String,
                       @SerializedName("extension")
                       val extensao: String){
    fun getImagePath(imageResolution: String): String {
        return "$path/$imageResolution.$extensao".replace("http://", "https://")
    }
}