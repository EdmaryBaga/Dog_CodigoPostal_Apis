package com. bbva.intranet.baz.edithbautista.Fragments

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bbva.intranet.baz.R
import com.bbva.intranet.baz.edithbautista.Constants
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalCp

class ImagenesCpFragment : Fragment() {

    companion object{
        fun newInstance(): ImagenesCpFragment {
            return ImagenesCpFragment()
        }
    }

    lateinit var editxtCp :EditText
    lateinit var btnEnviarCp :Button
    lateinit var cpo :String

    var pedirdatos=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (pedirdatos){
            Handler().postDelayed({
                DataExternalCp.getColonias(cpo)
            }, 4000)

        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.imagenes_cp_fragment, container, false)
        editxtCp = v.findViewById(R.id.ccp_editxt)
        btnEnviarCp= v.findViewById(R.id.btn_enviar_cp)


        btnEnviarCp.setOnClickListener {
             cpo = editxtCp.text.toString()
            if (cpo.length!= 5){
                Toast.makeText(activity, "Su cp debe ser de 5 caracteres", Toast.LENGTH_LONG).show()
            }
            else{

                pedirdatos=true
                onCreate(savedInstanceState)
                Toast.makeText(activity, "Su codigo postal se enviara", Toast.LENGTH_LONG).show()
            }
        }


        return  v
    }

    fun resibeColonias(colonias: MutableList<String>?){
        Log.e(Constants.TAG_SERVICES, "${colonias}")
    }


}