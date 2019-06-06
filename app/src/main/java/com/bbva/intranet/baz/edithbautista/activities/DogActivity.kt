package com.bbva.intranet.baz.edithbautista.activities
import android.support.v4.app.Fragment
import com.bbva.intranet.baz.edithbautista.Fragments.ListBreedFragment


class DogActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return ListBreedFragment.newInstance()
    }
    
}
