package Frangment

import Adapter.BannerAdapter
import Service.APIService
import Service.DataClient
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import com.example.appmp3.R
import kotlinx.android.synthetic.main.fragment_banner.*
import model.QuangCao
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class Fragment_Banner:Fragment() {
  var curentitem:Int = 0
    var hanler:Handler? = null
    var runable:Runnable? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_banner,container,false)
        Getdata()
        return view
    }

    private fun Getdata() {
        var dataClient:DataClient = APIService.getData()
        var callback:retrofit2.Call<List<QuangCao>> = dataClient.Getdata()
        callback.enqueue(object : retrofit2.Callback<List<QuangCao>> {
            override fun onFailure(call: Call<List<QuangCao>>, t: Throwable) {
                Log.d("CCC",t.message)
            }

            override fun onResponse(call: Call<List<QuangCao>>, response: Response<List<QuangCao>>) {
                var banners:ArrayList<QuangCao> = response.body() as ArrayList<QuangCao>
                var baneradapter:BannerAdapter = BannerAdapter(activity!!,banners)
                viewpager.adapter=baneradapter
                circleindica.setViewPager(viewpager)
                hanler = Handler()
                runable = object :Runnable{
                    override fun run() {
                        curentitem = viewpager.currentItem
                        curentitem++
                        if (curentitem!! >= (viewpager.adapter as BannerAdapter).count){
                            curentitem = 0
                        }
                        viewpager.setCurrentItem(curentitem!!,true)
                        hanler!!.postDelayed(runable,4500)
                }
                }
                hanler!!.postDelayed(runable,4500)




            }

        })
    }
}