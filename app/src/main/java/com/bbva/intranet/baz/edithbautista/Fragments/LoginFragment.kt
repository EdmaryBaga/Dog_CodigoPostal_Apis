package com.bbva.intranet.baz.edithbautista.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.bbva.intranet.baz.R
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalDog
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalUsuario
import com.bbva.intranet.baz.edithbautista.activities.DogActivity

import com.bbva.intranet.baz.edithbautista.model.Usuario

class LoginFragment : Fragment() {




    companion object{
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
        //Modificar despues de las pruebas
        var accesoFrag = true
        var usu= " "
        var usuarioData=Usuario(null,null)

    }

    lateinit var btn_iniciarSesion:Button
    lateinit var edit_txt_usuario:EditText
    lateinit var edit_txt_pwd:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            DataExternalUsuario.sendUsuario(usuarioData)
        }, 2000)
        if (accesoFrag){
            creaFragList()
        }
    }
    fun permisoAcceso(access: Boolean, usuario: String?){
        accesoFrag = access
        usu= usuario.toString()
    }


    @SuppressLint("CommitTransaction")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.login_fragment, container, false)

        btn_iniciarSesion = v.findViewById(R.id.btn_login)
        edit_txt_usuario = v.findViewById(R.id.edit_txt_usuario)
        edit_txt_pwd = v.findViewById(R.id.edit_txt_contrasena)
        btn_iniciarSesion.setOnClickListener {

            val usu = edit_txt_usuario.text.toString()
            val pwd = edit_txt_pwd.text.toString()
            usuarioData=Usuario(usu,pwd)
            onCreate(savedInstanceState)
        }
        return v
    }

    fun creaFragList(){
        val fragList = ListBreedFragment()
        DogActivity()
        val fm = fragmentManager?.beginTransaction()
        fm?.replace(R.id.fragment_container,fragList )
        fm?.addToBackStack(null)
        fm?.commit()
        DataExternalDog.getRaces()
    }

}