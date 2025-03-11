package com.example.app_que_caique_pediu.api

import com.example.app_que_caique_pediu.model.ModeloApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("{cep}/json/")
    fun buscarEndereco( @Path("cep", encoded = true) cep:String): Call<ModeloApi>
}