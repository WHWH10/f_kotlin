package com.example.myapplication.안드로이드_Essential

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFragmentOneBinding
import com.example.myapplication.databinding.ActivityTabPagerBinding
import com.example.myapplication.databinding.TabFragmentBinding
import com.google.android.material.tabs.TabLayout

class TabPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTabPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabPagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("One"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Two"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Three"))
        binding.tabLayout.setSelectedTabIndicatorColor(getColor(R.color.black))

        val pagerAdapter = PagerAdapter(supportFragmentManager, 3)
        binding.viewPager.adapter = pagerAdapter

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }
        })

        // 페이저가 이동했을 때 탭을 이동시키는 코드
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

    }
}

class PagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }
            else -> {
                return Fragment1()
            }
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}

class Fragment1 : Fragment() {
    private var fragmentOneBinding: TabFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle_fragment", "onCreateView")
        return inflater.inflate(R.layout.tab_fragment, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("life_cycle_fragment", "onViewCreated")

        val binding = TabFragmentBinding.bind(view)
        fragmentOneBinding = binding
        binding.tabText.text = "Tab One"
    }
}

class Fragment2 : Fragment() {

    private var fragmentOneBinding: TabFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle_fragment", "onCreateView")
        return inflater.inflate(R.layout.tab_fragment, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("life_cycle_fragment", "onViewCreated")

        val binding = TabFragmentBinding.bind(view)
        fragmentOneBinding = binding
        binding.tabText.text = "Tab Two"
    }
}

class Fragment3 : Fragment() {
    private var fragmentOneBinding: TabFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle_fragment", "onCreateView")
        return inflater.inflate(R.layout.tab_fragment, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("life_cycle_fragment", "onViewCreated")

        val binding = TabFragmentBinding.bind(view)
        fragmentOneBinding = binding
        binding.tabText.text = "Tab Three"
    }
}