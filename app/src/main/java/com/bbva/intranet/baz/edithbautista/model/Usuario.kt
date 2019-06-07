package com.bbva.intranet.baz.edithbautista.model

import com.google.gson.annotations.SerializedName

data class Usuario(@SerializedName("Usuario") val usu: String?,
                   @SerializedName("Password") val pwd: String?
)