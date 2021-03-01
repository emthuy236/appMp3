package Frangment

import Adapter.AlbumAdapter
import Service.APIService
import Service.DataClient
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmp3.R
import kotlinx.android.synthetic.main.fragment_album.*
import model.AlBum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment_Album:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_album,container,false)
        Getdata()
        return view
    }

    private fun Getdata() {
        var data:DataClient = APIService.getData()
        var call:Call<List<AlBum>> = data.Getdataalbum()
        call.enqueue(object :Callback<List<AlBum>>{
            override fun onFailure(call: Call<List<AlBum>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<AlBum>>, response: Response<List<AlBum>>) {
                var arrayabum:ArrayList<AlBum> = response.body() as ArrayList<AlBum>
                recycleabum.adapter = AlbumAdapter(activity!!,arrayabum)
                var linearmanage:GridLayoutManager = GridLayoutManager(activity,1)
                linearmanage.orientation = GridLayoutManager.HORIZONTAL
                recycleabum.layoutManager = linearmanage


            }

        })
    }
}