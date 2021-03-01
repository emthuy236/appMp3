package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.appmp3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_playlist.view.*
import model.Playlistnew

class AdapterPlaylist(var mctx:Context,var resources:Int, var items:List<Playlistnew>) :ArrayAdapter<Playlistnew>(mctx,resources,items){
    class ViewHolder(row:View){
        var txtTen:TextView
        var imgbackground:ImageView
        var imgicon:ImageView
        init {
            txtTen = row.findViewById(R.id.txtlist)
            imgbackground = row.findViewById(R.id.imgplaylist)
            imgicon = row.findViewById(R.id.imgiconlist)
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view:View?
        var viewholder:ViewHolder
        if (convertView == null){
            var layout:LayoutInflater = LayoutInflater.from(mctx)
            view = layout.inflate(R.layout.dong_playlist,null)
            viewholder = ViewHolder(view)
            view.tag = viewholder
        }else{
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }
        var playList: Playlistnew? = getItem(position)
        Picasso.with(mctx).load(playList!!.hinh).into(viewholder.imgbackground)
        Picasso.with(mctx).load(playList!!.icon).into(viewholder.imgicon)
        viewholder.txtTen.setText(playList.ten)



        return view as View
    }

}

