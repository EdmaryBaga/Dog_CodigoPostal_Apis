package com.bbva.intranet.baz.edithbautista.model

import com.google.gson.annotations.SerializedName

data class LoginRespuesta(@SerializedName("id") var idU:String,
                          @SerializedName("Usuario") var usu:String,
                          @SerializedName("Password") var pwd:String,
                          @SerializedName("Token") var token:String)