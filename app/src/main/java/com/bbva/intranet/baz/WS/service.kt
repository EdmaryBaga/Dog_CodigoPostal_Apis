package com.bbva.intranet.baz.WS

import com.bbva.intranet.baz.edithbautista.model.DogImages
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface APIDogRaza{

    //@QueryMap url:Map<String, String>
    //@Url url:String
    @GET
    fun getDogImage(@Url url:String):Call<DogImages>

    @GET("/list/all")
    //Modificar el tipo generico
    fun getAllBreed():Call<DogImages>

    companion object{
        fun getRetrofit(): APIDogRaza {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //return retrofit.create(ListaMensajeApi::class.java)
            return retrofit.create(APIDogRaza::class.java)
        }
    }

}