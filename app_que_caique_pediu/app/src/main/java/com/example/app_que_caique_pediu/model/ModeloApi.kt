package com.example.app_que_caique_pediu.model

import com.google.gson.annotations.SerializedName

data class ModeloApi(

    @SerializedName("cep")
    var cep : String,

    @SerializedName("logradouro")
    var endereco : String,

    @SerializedName("bairro")
    var bairro : String,

    @SerializedName("estado")
    var estado : String,

    @SerializedName("localidade")
    var cidade : String





)
