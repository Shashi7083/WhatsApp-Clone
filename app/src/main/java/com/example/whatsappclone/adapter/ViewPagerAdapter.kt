package com.example.whatsappclone.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class  ViewPagerAdapter (private val context : Context, fm : FragmentManager?,val list : ArrayList<Fragment>,lifecycle: Lifecycle) : FragmentStateAdapter(fm!!,lifecycle){
    //    override fun getCount(): Int {
//        return list.size
//    }
//
//    override fun getItem(position: Int): Fragment {
//
//
//        return list[position]
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return TAB_TITLE[position]
//    }
//
//    companion object{
//        val TAB_TITLE =  arrayOf("Chat ","Status","Call")
//    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
     return list[position]
    }

}