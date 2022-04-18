package edu.ivytech.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.*

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            if(it.containsKey("item_key")) {
                val crimeId = it.getSerializable("item_key") as UUID
                //crimeDetailVM.loadCrime(crimeId)
            }
        }
    }
}