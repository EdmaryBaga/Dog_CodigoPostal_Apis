package com.bbva.intranet.baz.edithbautista.Controller

import com.bbva.intranet.baz.WS.APIDogRaza
import com.bbva.intranet.baz.edithbautista.Fragments.ListBreedFragment
import com.bbva.intranet.baz.edithbautista.model.DogImages
import com.bbva.intranet.baz.edithbautista.model.DogListBreed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class DataExternalDog() {

     companion object{
         fun getnewInstance(): DataExternalDog {
             return DataExternalDog()
         }

         var frag = ListBreedFragment()
         var listaR : MutableList<String> = mutableListOf()
         fun getRaces(): List<String>? {
             var lista:List<String>? = listOf()
             val listRaces = APIDogRaza.getRetrofitRaces()
             val call = listRaces.getAllRaces()
             //ListBreedFragment.newInstance()
             call.enqueue(object :Callback<DogListBreed>{

                 override fun onFailure(call: Call<DogListBreed>, t: Throwable) {
                     print("No hubo respuesta")
                     ListBreedFragment.newInstance()
                 }
                 override fun onResponse(call: Call<DogListBreed>, response: Response<DogListBreed>) {
                     listaR.addAll(response?.body()?.message!!)
                     print("la peticion se realizo")
                     frag.resive(listaR)
                 }
             })
             return listaR
         }

         open fun getImagesRace(raza: String): List<String>? {
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
                     lista = response.body()?.images
                 }
             })
             return lista
         }
     }










}