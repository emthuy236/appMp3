package Frangment

import Adapter.AdapterPlaylist
import Service.APIService
import Service.DataClient
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.example.appmp3.R
import kotlinx.android.synthetic.main.fragment_playlist.*
import model.Playlistnew
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment_Playlist:Fragment() {
    var arrayplaylist:ArrayList<Playlistnew> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_playlist,container,false)

        Getdata()
        return view
    }

    private fun Getdata() {
        var dataclient:DataClient = APIService.getData()
        var call:Call<List<Playlistnew>> = dataclient.Getplatlist()
        call.enqueue(object :Callback<List<Playlistnew>>{
            override fun onFailure(call: Call<List<Playlistnew>>, t: Throwable) {
                Log.d("BBB",t.message)
            }

            override fun onResponse(
                call: Call<List<Playlistnew>>,
                response: Response<List<Playlistnew>>
            ) {
                arrayplaylist = response.body() as ArrayList<Playlistnew>
                lvplaylist.adapter = AdapterPlaylist(context!!,android.R.layout.simple_list_item_1,arrayplaylist)
                setListViewHeightBasedOnChildren(lvplaylist)

            }

        })
    }
    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter
            ?: // pre
//
//
// -condition
            return
        var totalHeight = listView.paddingTop + listView.paddingBottom
        val desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.width, View.MeasureSpec.AT_MOST)
        for (i in 0 until listAdapter.count) {
            val listItem = listAdapter.getView(i, null, listView)
            if (listItem != null) { // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
                totalHeight += listItem.measuredHeight
            }
        }
        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
        listView.requestLayout()
    }
}