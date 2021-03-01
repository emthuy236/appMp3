package Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainViewpageradapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var arrayfragment:ArrayList<Fragment> = ArrayList()
    private var arraytitle:ArrayList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return arrayfragment.get(position)
    }

    override fun getCount(): Int {
        return arrayfragment.size
    }
    fun addfragment(fragment:Fragment,title:String){
        arrayfragment.add(fragment)
        arraytitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return arraytitle.get(position)
    }
}