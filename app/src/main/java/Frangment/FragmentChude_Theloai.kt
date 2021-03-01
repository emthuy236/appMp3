package Frangment

import Service.APIService
import Service.DataClient
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.appmp3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragmentchude_theloai.*
import model.ChuDe
import model.ChudevaTheloaitrongngay
import model.TheLoai
import retrofit2.Call
import retrofit2.Response

class FragmentChude_Theloai:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragmentchude_theloai,container,false)
        Getdata()
        return view
    }

    private fun Getdata() {
        var data:DataClient = APIService.getData()
        var call:Call<ChudevaTheloaitrongngay> = data.Getdatachuvaloai()
        call.enqueue(object :retrofit2.Callback<ChudevaTheloaitrongngay>{
            override fun onFailure(call: Call<ChudevaTheloaitrongngay>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ChudevaTheloaitrongngay>,
                response: Response<ChudevaTheloaitrongngay>
            ) {
                var chudevatheloai: ChudevaTheloaitrongngay? = response.body()
                var arraychude:ArrayList<ChuDe> = ArrayList()
                arraychude.addAll(chudevatheloai!!.chuDe!!)

                var arraytheloai:ArrayList<TheLoai> = ArrayList()
                arraytheloai.addAll(chudevatheloai!!.theLoai!!)

                var linear:LinearLayout = LinearLayout(activity)
                linear.orientation = LinearLayout.HORIZONTAL

                var layout:LinearLayout.LayoutParams = LinearLayout.LayoutParams(580,350)
                layout.setMargins(10,20,10,30)

                for(i in 0..(arraychude.size -1)){
                    var cardview:CardView = CardView(activity!!)
                    cardview.radius = 10F
                    var frame:FrameLayout = FrameLayout(activity!!)
                    var textview:TextView = TextView(activity)
                    textview.setText(arraychude.get(i).tenchude)
                    textview.setTextColor(Color.parseColor("#F6F4F4"))
                    textview.setTextSize(18F)
                    textview.gravity = Gravity.CENTER
                    var img:ImageView = ImageView(activity)
                    img.scaleType = ImageView.ScaleType.FIT_XY
                    frame.addView(img)
                    frame.addView(textview)
                    if(arraychude.get(i).hinhchude != null){
                        Picasso.with(context).load(arraychude.get(i).hinhchude).into(img)
                    }
                    cardview.layoutParams = layout
                    cardview.addView(frame)
                    linear.addView(cardview)
                }

                for(a in 0..(arraytheloai.size-1)){
                    var cardview1:CardView = CardView(activity!!)
                    cardview1.radius = 10F
                    var img1:ImageView = ImageView(activity)
                    img1.scaleType = ImageView.ScaleType.FIT_XY
                    if(arraytheloai.get(a).hinhtheloai != null){
                        Picasso.with(context).load(arraytheloai.get(a).hinhtheloai).into(img1)
                    }
                    cardview1.layoutParams = layout
                    cardview1.addView(img1)
                    linear.addView(cardview1)
                }
                scrollngang.addView(linear)
            }
        })
    }

}