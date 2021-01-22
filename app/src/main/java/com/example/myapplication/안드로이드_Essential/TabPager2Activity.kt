package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityTabPager2Binding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.activity_tab_pager2.*

class TabPager2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTabPager2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabPager2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("One"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Two"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Three"))
        binding.tabLayout.setSelectedTabIndicatorColor(getColor(R.color.black))

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }
        })


        val adapter = ThreePageAdapter(LayoutInflater.from(this@TabPager2Activity))
        binding.viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
    }
}

class ThreePageAdapter(
    val layoutInflater: LayoutInflater
): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        return super.instantiateItem(container, position)
        when(position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.tab_fragment, container, false)
                container.addView(view)
                view.findViewById<TextView>(R.id.tab_text).text = "TAB ONE"
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.tab_fragment, container, false)
                container.addView(view)
                view.findViewById<TextView>(R.id.tab_text).text = "TAB TWO"
                return view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.tab_fragment, container, false)
                container.addView(view)
                view.findViewById<TextView>(R.id.tab_text).text = "TAB THREE"
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.tab_fragment, container, false)
                container.addView(view)
                view.findViewById<TextView>(R.id.tab_text).text = "TAB DEFAULT"
                return view
            }
        }
//        return super.instantiateItem(container, position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
        container.removeView( `object` as View)
    }

    // === : 주소값 까지 같은지 비교하는 연산자
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ===  `object` as View
    }

    override fun getCount(): Int {
        return 3
    }

}