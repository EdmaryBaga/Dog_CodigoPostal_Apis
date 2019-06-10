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
import com.bbva.intranet.baz.edithbautista.activities.DogActivity
import java.util.*


@Suppress("UNREACHABLE_CODE")
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
             mRecycler?.layoutManager = linearLayout as RecyclerView.LayoutManager?
             mAdapter = RaceAdapter(ListaRazas!!, object : OnItemClickListener{
                 override fun OnItemClick(position: Int) {
                     var nombre=ListaRazas!!.get(position)
                     creaFragCp()
                 }

             })
             mRecycler?.adapter = mAdapter
         }, 1000)

        setHasOptionsMenu(true)
    }

    fun creaFragCp(){
        val fragCp = ImagenesCpFragment()
        DogActivity()
        var fm = fragmentManager?.beginTransaction()
        fm?.replace(R.id.fragment_container,fragCp )
        fm?.addToBackStack(null)
        fm?.commit()
        //peticion de imagenes
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.races_dog_list_fragment,container,false)
        mRecycler = v.findViewById(R.id.lista_razas)
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_lista_fragment, menu)
        //val subtitleItem = menu?.findItem(R.id.show_subtitle)
        val ordena = menu?.findItem(R.id.menu_ordenar)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_ordenar-> {val listaRaz : List<String> = ListaRazas!!.sortedBy { word->word.get(0) }
                mAdapter?.setAdapter(listaRaz.toMutableList())
            return true}

            else->{return super.onOptionsItemSelected(item)}
        }

    }


    /*override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
        when(item?.itemId){
            R.id.menu_ordenar->{
                val lista2 = ListaRazas?.sort() as MutableList<String>
                mAdapter?.setAdapter(lista2)
                return true
            }
        else ->{return super.onOptionsItemSelected(item)}
        }
    }*/

    fun resive(list:MutableList<String>?){
       ListaRazas?.addAll(list!!)
    }

    /*----Holder------*/
    inner class RaceHolder(var v:View):RecyclerView.ViewHolder(v){
        init {
            mRazaTxt = v.findViewById(R.id.raza_txt)
        }
        fun bin(raza: String,listener: OnItemClickListener){
            mRazaTxt?.text= raza

            v.setOnClickListener {
                listener.OnItemClick(adapterPosition)
            }
        }
    }

    /*----Adapter------*/
    inner class RaceAdapter(var listaRazas: MutableList<String>, var listener: OnItemClickListener): RecyclerView.Adapter<RaceHolder>() {

        override fun onCreateViewHolder(v: ViewGroup, viewType: Int): RaceHolder {
            val inflater = LayoutInflater.from(activity)
            val view = inflater.inflate(R.layout.race_dog_item, v, false)
            return RaceHolder(view)
        }

        override fun getItemCount(): Int {
            return listaRazas.size
        }

        fun setAdapter(lista: MutableList<String>?){
            listaRazas.clear()
            listaRazas.addAll(lista!!)
            notifyDataSetChanged()
        }
        override fun onBindViewHolder(holder: RaceHolder, position: Int) {
            var razaTxt = listaRazas.get(position)
            holder.bin(razaTxt, listener)
        }



    }
    interface OnItemClickListener{
        fun OnItemClick(position: Int)
    }




}