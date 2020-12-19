package com.alie.submission.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alie.submission.view.FragmentFollower
import com.alie.submission.view.FragmentFollowing

@Suppress("DEPRECATION")
class PagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return FragmentFollower()
            1 -> return FragmentFollowing()
        }
        return FragmentFollower()
    }

}