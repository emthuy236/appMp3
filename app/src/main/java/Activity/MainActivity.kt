package Activity

import Adapter.MainViewpageradapter
import Frangment.Fragment_Timkiem
import Frangment.Fragment_Trangchu
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmp3.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        var mainviewpager:MainViewpageradapter = MainViewpageradapter(supportFragmentManager)
        mainviewpager.addfragment(Fragment_Trangchu(),"Trang chủ")
        mainviewpager.addfragment(Fragment_Timkiem(),"Tìm kiếm")
        myViewpager.adapter = mainviewpager
        myTablayout.setupWithViewPager(myViewpager)
        myTablayout.getTabAt(0)?.setIcon(R.drawable.icontrangchu)
        myTablayout.getTabAt(1)?.setIcon(R.drawable.iconsearch)
    }
}
