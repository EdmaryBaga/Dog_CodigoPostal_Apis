package com.bbva.intranet.baz.edithbautista.model

import com.google.gson.annotations.SerializedName

data class Cp(
    @SerializedName("codigo posta")
    var codigo_posta:String,
    @SerializedName("municipio")
    var municipio :String,
    @SerializedName("estado")
    var estado :String,
    @SerializedName("colonias")
    var colonias : MutableList<String>
)

