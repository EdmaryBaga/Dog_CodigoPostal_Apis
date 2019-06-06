package com.bbva.intranet.baz.edithbautista.activities


import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.bbva.intranet.baz.R

/*
* SingleFragmentActivity indica quien es el fragmento
* **/

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract fun createFragment():Fragment

    //Este metodo debuelve el id del layout que se inflara
    @LayoutRes protected open fun getLayoutResId():Int{
        return R.layout.dog_activity_fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //llamamos al metodo para saber que layout se utlizara
        setContentView(getLayoutResId())

        val fm:FragmentManager=supportFragmentManager
        var fragment: Fragment? =fm.findFragmentById(R.id.fragment_container)
        if (fragment==null){
            fragment=createFragment()
                fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }


}