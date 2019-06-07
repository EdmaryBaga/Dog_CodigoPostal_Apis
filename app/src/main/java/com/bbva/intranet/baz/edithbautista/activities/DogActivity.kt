package com.bbva.intranet.baz.edithbautista.activities
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import com.bbva.intranet.baz.R
import com.bbva.intranet.baz.edithbautista.Controller.DataExternalDog
import com.bbva.intranet.baz.edithbautista.Fragments.ListBreedFragment
import com.bbva.intranet.baz.edithbautista.Fragments.LoginFragment
import com.bbva.intranet.baz.edithbautista.model.DogListBreed
import kotlinx.android.synthetic.main.login_fragment.*


class DogActivity : SingleFragmentActivity() {

    var btn_iniciarSesion : Button? = null

    override fun createFragment(): Fragment {
        //DataExternalDog.getnewInstance().getRaces()
         return LoginFragment.newInstance()
    }

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val LoginFrag = LoginFragment()
        val ListFrag = ListBreedFragment()

        btn_iniciarSesion = btn_login
        btn_iniciarSesion!!.setOnClickListener {
            var ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container, ListFrag)
            ft.addToBackStack(null)
            ft.commit()
        }


    }*/


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
