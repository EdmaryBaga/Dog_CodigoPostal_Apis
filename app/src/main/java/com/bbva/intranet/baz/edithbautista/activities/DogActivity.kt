package com.bbva.intranet.baz.edithbautista.activities
import android.support.v4.app.Fragment
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalDog
import com.bbva.intranet.baz.edithbautista.Fragments.ListBreedFragment


class DogActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        //DataExternalDog.getnewInstance().getRaces()
         return ListBreedFragment.newInstance()
    }

    /* override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         val QueryRaza ="entlebucher"

         var urlF= "/api/breed/${QueryRaza}/images"

         var listImage = APIDogRaza.getRetrofit()
         var call = listImage.getDogImage(urlF)
         call.enqueue(object : Callback<DogImages>{
             override fun onFailure(call: Call<DogImages>, t: Throwable) {
                 print("Respuesta No exitosa")
             }

             override fun onResponse(call: Call<DogImages>, response: Response<DogImages>) {
                 print("Respuesta exitosa")
             }
         })
     }*/


}
