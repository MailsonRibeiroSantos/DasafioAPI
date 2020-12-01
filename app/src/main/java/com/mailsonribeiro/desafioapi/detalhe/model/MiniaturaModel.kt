package com.mailsonribeiro.desafioapi.detalhe.model

import com.google.gson.annotations.SerializedName

data class MiniaturaModel(@SerializedName("path")
                     val pathMini: String,
                     @SerializedName("extension")
                     val extensaoMini: String){
    fun getImagePath(imageResolution: String): String {
        return "$pathMini/$imageResolution.$extensaoMini".replace("http://", "https://")
    }
}