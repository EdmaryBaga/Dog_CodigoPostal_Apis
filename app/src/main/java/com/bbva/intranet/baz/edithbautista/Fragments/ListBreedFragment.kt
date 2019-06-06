package com.bbva.intranet.baz.edithbautista.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment

class ListBreedFragment : Fragment() {

companion object{
    fun newInstance():ListBreedFragment{
        return ListBreedFragment()
    }
}
    lateinit var ListaRazas : List<String>


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}