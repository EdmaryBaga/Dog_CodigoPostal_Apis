package com.bbva.intranet.baz.edithbautista.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bbva.intranet.baz.R
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalDog
import com.bbva.intranet.baz.edithbautista.activities.DogActivity

import com.bbva.intranet.baz.edithbautista.activities.SingleFragmentActivity
import com.bumptech.glide.manager.SupportRequestManagerFragment
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {




    companion object{
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    lateinit var btn_iniciarSesion:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    @SuppressLint("CommitTransaction")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.login_fragment, container, false)

        btn_iniciarSesion = v.findViewById(R.id.btn_login)
        btn_iniciarSesion.setOnClickListener {

            val fragList = ListBreedFragment()
            DogActivity()
            var fm = fragmentManager?.beginTransaction()
            fm?.replace(R.id.fragment_container,fragList )
            fm?.addToBackStack(null)
            fm?.commit()
            DataExternalDog.getRaces()
        }
        return v
    }

}