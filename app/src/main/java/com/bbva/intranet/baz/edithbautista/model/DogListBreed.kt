package com.bbva.intranet.baz.edithbautista.model

import com.google.gson.annotations.SerializedName

data class DogListBreed(
    @SerializedName("status")
    var status:String,
    @SerializedName("message")
    var message:MutableList<String>)