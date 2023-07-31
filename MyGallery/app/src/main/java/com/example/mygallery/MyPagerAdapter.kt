package com.example.mygallery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var items = ArrayList<Fragment>()

    //position 위치의 프레그먼트
    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getCount(): Int {
        return  items.size

    }

    fun updateFragments(items: List<Fragment>){
        this.items.addAll(items)
    }
}