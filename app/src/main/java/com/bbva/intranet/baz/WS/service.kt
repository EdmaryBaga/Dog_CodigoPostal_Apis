package com.bbva.intranet.baz.WS

import com.bbva.intranet.baz.edithbautista.model.DogImages
import com.bbva.intranet.baz.edithbautista.model.DogListBreed
import com.bbva.intranet.baz.edithbautista.model.LoginRespuesta
import com.bbva.intranet.baz.edithbautista.model.Usuario
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*

interface APIDogRaza{

    //@QueryMap url:Map<String, String>
    //@Url url:String
    @GET
    fun getDogImage(@Url url:String):Call<DogImages>

    @GET("/v2/5cf93b70340000262e01b465")
    //Modificar el tipo generico
    fun getAllRaces():Call<DogListBreed>
//http://www.mocky.io/v2/5cf93b70340000262e01b465

    companion object{
        fun getRetrofit(): APIDogRaza {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //return retrofit.create(ListaMensajeApi::class.java)
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