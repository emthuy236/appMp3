package Frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appmp3.R

class Fragment_Trangchu: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.frangment_trangchu,container,false)
        return view
    }
}