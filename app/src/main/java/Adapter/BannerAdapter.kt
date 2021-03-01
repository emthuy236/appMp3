package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.appmp3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dong_banner.view.*
import model.QuangCao

class BannerAdapter(var context:Context,var arrayquangcao:ArrayList<QuangCao>):PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var infla:LayoutInflater = LayoutInflater.from(context)
        var view:View = infla.inflate(R.layout.dong_banner,null)
        Picasso.with(context).load(arrayquangcao.get(position).idhinhanh).into(view.imgbanner)
        Picasso.with(context).load(arrayquangcao.get(position).hinhbaihat).into(view.imghinhban)
        view.txttitle.setText(arrayquangcao.get(position).tenbaihat)
        view.txtnoidung.setText(arrayquangcao.get(position).idnoidung)
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return arrayquangcao.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}