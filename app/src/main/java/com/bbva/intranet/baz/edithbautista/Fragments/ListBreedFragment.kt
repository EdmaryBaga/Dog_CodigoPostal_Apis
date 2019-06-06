package com.bbva.intranet.baz.edithbautista.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bbva.intranet.baz.R
import com.bbva.intranet.baz.WS.APIDogRaza
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalDog

class ListBreedFragment : Fragment() {

companion object{
    fun newInstance():ListBreedFragment{
        return ListBreedFragment()
    }
}

   var ListaRazas : List<String> = listOf("affenpinscher",
        "african",
        "airedale",
        "akita",
        "appenzeller",
        "basenji",
        "beagle",
        "bluetick",
        "borzoi",
        "bouvier",
        "boxer",
        "brabancon",
        "briard",
        "bulldog",
        "bullterrier",
        "cairn",
        "cattledog",
        "chihuahua",
        "chow",
        "clumber",
        "cockapoo",
        "collie",
        "coonhound",
        "corgi",
        "cotondetulear",
        "dachshund",
        "dalmatian",
        "dane",
        "deerhound",
        "dhole",
        "dingo",
        "doberman",
        "elkhound",
        "entlebucher",
        "eskimo",
        "frise",
        "germanshepherd",
        "greyhound",
        "groenendael",
        "hound",
        "husky",
        "keeshond",
        "kelpie",
        "komondor",
        "kuvasz",
        "labrador",
        "leonberg",
        "lhasa",
        "malamute",
        "malinois",
        "maltese",
        "mexicanhairless",
        "mix",
        "mountain",
        "newfoundland",
        "otterhound",
        "papillon",
        "pekinese",
        "pembroke",
        "pinscher",
        "pointer")

    //var ListaRazas : List<String>? = listOf()

    private var mRazaTxt: TextView? = null
    lateinit var linearLayout : LinearLayoutManager
    var mRecycler :RecyclerView? = null
    var mAdapter :RaceAdapter? = null
    var mDBDog : List<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* mDBDog= DataExternalDog.getnewInstance().getRaces()
        ListaRazas = obtenRazas()
        CreaRecyaler(ListaRazas)*/
    }
    fun obtenRazas(): List<String>? {
        return DataExternalDog.getnewInstance().getRaces()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.races_dog_list_fragment,container,false)
        mRecycler = v.findViewById(R.id.lista_razas)
        val listRaces = APIDogRaza.getRetrofitRaces()
        val call = listRaces.getAllRaces()
        DataExternalDog.getnewInstance().execute(call)
        CreaRecyaler(ListaRazas)
        return v

    }

    override fun onResume() {
        super.onResume()
       // CreaRecyaler(ListaRazas)
    }
    fun CreaRecyaler(lista: List<String>?){
        //ListaRazas = DataExternalDog.getnewInstance().getRaces()
        //mCrimeRecyclerView?.layoutManager= LinearLayoutManager(activity)
        linearLayout = LinearLayoutManager(activity)
        mRecycler?.layoutManager = linearLayout
        mAdapter = ListaRazas?.let { RaceAdapter(it) }
        mRecycler?.adapter = mAdapter
    }

    inner class RaceHolder(v:View):RecyclerView.ViewHolder(v){

        init {
            mRazaTxt = v.findViewById(R.id.raza_txt)
        }

        fun bin(raza:String){
            mRazaTxt?.text= raza
        }
    }

    inner class RaceAdapter(val listaRazas:List<String>): RecyclerView.Adapter<RaceHolder>() {
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