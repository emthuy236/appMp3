package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmp3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_album.view.*
import model.AlBum

class AlbumAdapter(var context:Context, var arrayabum:ArrayList<AlBum>):
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        var nameabum:TextView
        var namecasi:TextView
        var hinhabum:ImageView
        init {
            nameabum = itemview.findViewById(R.id.txtabum)
            namecasi = itemview.findViewById(R.id.txttencasi)
            hinhabum = itemview.findViewById(R.id.imgabum)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout:LayoutInflater = LayoutInflater.from(context)
        var view:View = layout.inflate(R.layout.custom_album,null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayabum.size
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var album: AlBum = arrayabum.get(position)
        holder.nameabum.setText(album.tenabum)
        holder.namecasi.setText(album.tencasiabum)
        Picasso.with(context).load(album.hinhabum).into(holder.hinhabum)

    }
}