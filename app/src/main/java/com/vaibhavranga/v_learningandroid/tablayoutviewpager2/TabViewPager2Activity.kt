package com.vaibhavranga.v_learningandroid.tablayoutviewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.vaibhavranga.v_learningandroid.R
import com.vaibhavranga.v_learningandroid.databinding.ActivityTabViewPager2Binding

class TabViewPager2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTabViewPager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabViewPager2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        binding.viewPager.adapter = ViewPagerAdapter(fragmentManager, lifecycle)

        val tabsList = listOf<TabModel>(
            TabModel("Chats", R.drawable.baseline_chat_24),
            TabModel("Status", R.drawable.status),
            TabModel("Calls", R.drawable.baseline_call_24)
        )

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    tab.text = tabsList[position].title
                    tab.icon = ResourcesCompat.getDrawable(resources, tabsList[position].icon, null)
                }
            }).attach()
    }
}