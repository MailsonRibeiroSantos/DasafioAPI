package com.mailsonribeiro.desafioapi.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class NetworkInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = System.currentTimeMillis().toString()
        val  apikey = PUBLIC_KEY
        val hash = getHash(ts)

        val request= chain.request()

        val url_ = request.url().newBuilder()
            .addQueryParameter("ts",ts)
            .addQueryParameter("apikey",apikey)
            .addQueryParameter("hash", hash).build()

        return chain.proceed(request.newBuilder().url(url_).build())

    }


    fun md5(stringToHash: String): String {
        val md5 = "MD5"
        try {
            val digest = MessageDigest.getInstance(md5)
            digest.update(stringToHash.toByteArray())
            val messageDigest = digest.digest()

            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) {
                    h = "0$h"
                }
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }



    fun getHash(ts:String): String? {
        return md5(ts + PRIVATE_KEY + PUBLIC_KEY)
    }

    companion object{
        private const val PUBLIC_KEY ="6eb7e8896ec5850c52515a8a23ee97f0"
        private const val PRIVATE_KEY ="0dd0c16fedb8a02985977eafca66b49f5e6a526f"

        private const val TS = "ts"
        private const val API_KEY = "apikey"
        private const val HASH = "hash"
    }

}