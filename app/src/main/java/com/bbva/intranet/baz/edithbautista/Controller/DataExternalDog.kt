package com.bbva.intranet.baz.edithbautista.Controller

import com.bbva.intranet.baz.WS.APIDogRaza
import com.bbva.intranet.baz.edithbautista.model.DogImages
import com.bbva.intranet.baz.edithbautista.model.DogListBreed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataExternalDog{

        fun getImagesRace(raza: String): List<String>? {
            var urlF= "/api/breed/${raza}/images"

            var lista : List<String>? = listOf()
            var listImage = APIDogRaza.getRetrofit()
            var call = listImage.getDogImage(urlF)
            call.enqueue(object : Callback<DogImages> {
                override fun onFailure(call: Call<DogImages>, t: Throwable) {
                    print("Respuesta No exitosa")
                }
                override fun onResponse(call: Call<DogImages>, response: Response<DogImages>) {
                    print("Respuesta exitosa")
                    lista = response?.body()?.images
                }
            })
            return lista
        }

        fun getRaces(raza: String): List<String>? {
            var listaR : List<String>? = listOf()
            var listImage = APIDogRaza.getRetrofitRaces()
            var call = listImage.getAllRaces()
            call.enqueue(object : Callback<DogListBreed> {
                override fun onFailure(call: Call<DogListBreed>, t: Throwable) {
                    print("Respuesta No exitosa")
                }

                override fun onResponse(call: Call<DogListBreed>, response: Response<DogListBreed>) {
                    listaR= response?.body()?.message
                    print("Respuesta exitosa")
                }
            })
            return listaR
        }
}