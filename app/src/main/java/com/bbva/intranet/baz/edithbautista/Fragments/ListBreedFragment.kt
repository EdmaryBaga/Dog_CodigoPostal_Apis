package com.bbva.intranet.baz.edithbautista.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.TextView
import com.bbva.intranet.baz.R

class ListBreedFragment : Fragment() {

companion object{
    fun newInstance():ListBreedFragment{
        return ListBreedFragment()
    }

    lateinit var linearLayout : LinearLayoutManager
    @SuppressLint("StaticFieldLeak")
    var mRecycler :RecyclerView? = null
    var mAdapter :RaceAdapter? = null
    var ListaRazas : MutableList<String>? = mutableListOf()
}
    private var mRazaTxt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         Handler().postDelayed({
             mRecycler = view?.findViewById(R.id.lista_razas)
             linearLayout = LinearLayoutManager(activity)
             mRecycler?.layoutManager = linearLayout
             mAdapter = RaceAdapter(ListaRazas!!)
             mRecycler?.adapter = mAdapter
         }, 1000)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.races_dog_list_fragment,container,false)
        mRecycler = v.findViewById(R.id.lista_razas)
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_lista_fragment, menu)
    }

    fun resive(list:MutableList<String>?){
       ListaRazas?.addAll(list!!)
    }

    inner class RaceHolder(v:View):RecyclerView.ViewHolder(v){
        init {
            mRazaTxt = v.findViewById(R.id.raza_txt)
        }
        fun bin(raza:String){
            mRazaTxt?.text= raza
        }
    }

    inner class RaceAdapter(val listaRazas: List<String>): RecyclerView.Adapter<RaceHolder>() {
        override fun onCreateViewHolder(v: ViewGroup, viewType: Int): RaceHolder {
            val inflater = LayoutInflater.from(activity)
            val view = inflater.inflate(R.layout.race_dog_item, v, false)
            return RaceHolder(view)

        }
        override fun getItemCount(): Int {
            return listaRazas.size
        }
        override fun onBindViewHolder(holder: RaceHolder, position: Int) {
            var razaTxt = listaRazas.get(position)
            holder.bin(razaTxt)
        }
    }
}