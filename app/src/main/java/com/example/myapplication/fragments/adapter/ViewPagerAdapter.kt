package com.example.myapplication.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(
    supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    private val mfraglist = ArrayList<Fragment>()
    private val mfragTitlelist = ArrayList<String>()

    override fun getCount(): Int {
        return mfraglist.size
    }

    override fun getItem(position: Int): Fragment {
        return mfraglist[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mfragTitlelist[position]
    }

    fun addfragment(fragment: Fragment, title: String) {
        mfragTitlelist.add(title)
        mfraglist.add(fragment)
    }

}