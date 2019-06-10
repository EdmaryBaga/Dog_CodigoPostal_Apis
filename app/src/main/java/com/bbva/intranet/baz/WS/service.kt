package com.bbva.intranet.baz.WS

import com.bbva.intranet.baz.edithbautista.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*

interface APIDogRaza{

    //@QueryMap url:Map<String, String>
    @GET
    fun getDogImage(@Url url:String):Call<DogImages>

    @GET("/v2/5cf93b70340000262e01b465")
    fun getAllRaces():Call<DogListBreed>

    companion object{
        fun getRetrofit(): APIDogRaza {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(APIDogRaza::class.java)
        }

    fun getRetrofitRaces(): APIDogRaza {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(APIDogRaza::class.java)
    }
    }
}

interface ApiLoginDog{
    @POST(value = "/LoginService")
    @Headers("Content-Type:application/json")
    fun sendUsu(@Body modelusu:Usuario): Call<LoginRespuesta>

    companion object{

        fun getClienteUsuario(): ApiLoginDog {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://5ca653603a082600142796d8.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiLoginDog::class.java)
        }

    }
}

interface ApiCp{

    @GET
    fun getColonias(@Url url:String):Call<Cp>

    companion object{
        fun creaClienteCp(): ApiCp {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api-codigos-postales.herokuapp.com/v2/codigo_postal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiCp::class.java)
        }


    }

}