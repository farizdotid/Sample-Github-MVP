package io.mvpstarter.sample.features.home

import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import io.mvpstarter.sample.BuildConfig
import io.mvpstarter.sample.R
import io.mvpstarter.sample.features.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject lateinit var homeTabAdapter: HomeTabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent().inject(this)

        setupTabLayout()
    }

    override fun layoutId(): Int {
        return R.layout.activity_home
    }

    private fun setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Users"))
        tabLayout.addTab(tabLayout.newTab().setText("Repositories"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        homeTabAdapter = HomeTabAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = homeTabAdapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        })
    }
}
