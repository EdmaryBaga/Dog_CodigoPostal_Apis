package com.bbva.intranet.baz.edithbautista.Controller

import android.annotation.SuppressLint
import android.util.Log
import com.bbva.intranet.baz.WS.ApiCp
import com.bbva.intranet.baz.edithbautista.Constants
import com.bbva.intranet.baz.edithbautista.Fragments.ImagenesCpFragment
import com.bbva.intranet.baz.edithbautista.model.Cp
import retrofit2.Call
import retrofit2.Response

class DataExternalCp{


    companion object{
        @SuppressLint("StaticFieldLeak")
        var fragment = ImagenesCpFragment()
        var listColonias : MutableList<String>? = mutableListOf()

        fun getColonias(cp:String){
            val clientecp= ApiCp.creaClienteCp()
            val callCp = clientecp.getColonias(cp)
            callCp.enqueue(object : retrofit2.Callback<Cp>{
                override fun onResponse(call: Call<Cp>, response: Response<Cp>) {
                    listColonias = response.body()?.colonias
                    fragment.resibeColonias(listColonias)
                }
                override fun onFailure(call: Call<Cp>, t: Throwable) {
                    Log.e(Constants.TAG_SERVICES, "No se realizo el servicio")
                }


            })
        }


    }

    /*
    *  var frag = ListBreedFragment()
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
    * */




}