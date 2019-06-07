package com.bbva.intranet.baz.edithbautista.Controller

import android.util.Log
import com.bbva.intranet.baz.WS.ApiLoginDog
import com.bbva.intranet.baz.edithbautista.Constants
import com.bbva.intranet.baz.edithbautista.Fragments.LoginFragment
import com.bbva.intranet.baz.edithbautista.model.LoginRespuesta
import com.bbva.intranet.baz.edithbautista.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataExternalUsuario{

    companion object{

        var acceso = false

        var fragLogin = LoginFragment()

        fun sendUsuario(usuario:Usuario){
            if (usuario.usu !=null){
                var usuarioRes : LoginRespuesta
                val usuarioPost = ApiLoginDog.getClienteUsuario()
                val call = usuarioPost.sendUsu(usuario)
                call.enqueue(object : Callback<LoginRespuesta>{
                    override fun onResponse(call: Call<LoginRespuesta>, response: Response<LoginRespuesta>) {
                        response.body()?.idU
                        acceso= true
                        var usuario = response.body()?.usu
                        fragLogin.permisoAcceso(acceso, usuario)
                        Log.e(Constants.TAG_SERVICES, "La respuesta fue exitosa")
                    }

                    override fun onFailure(call: Call<LoginRespuesta>, t: Throwable) {
                        Log.e(Constants.TAG_SERVICES, "La peticion fallo")
                    }
                })
            }


        }

    }

}