package com.bbva.intranet.baz.edithbautista.model

import com.google.gson.annotations.SerializedName

data class DogImages (
    @SerializedName("status")
    var status:String,
    @SerializedName("message")
    var images: List<String>)
